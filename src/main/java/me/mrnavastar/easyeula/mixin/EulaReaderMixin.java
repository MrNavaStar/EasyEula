package me.mrnavastar.easyeula.mixin;

import me.mrnavastar.easyeula.EasyEula;
import net.minecraft.server.dedicated.EulaReader;
import org.apache.logging.log4j.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

@Mixin(EulaReader.class)
public class EulaReaderMixin {

    @Shadow @Final private boolean eulaAgreedTo;
    @Unique
    private boolean eulaUpdated;

    @Unique
    private final List<String> validInput = List.of(new String[]{"y", "yes", ""});

    @Inject(method = "<init>", at = @At("TAIL"))
    private void init(Path eulaFile, CallbackInfo ci) {
        if (!eulaAgreedTo) {
            EasyEula.log(Level.WARN, "Please indicate your agreement to the minecraft EULA (https://aka.ms/MinecraftEULA)");
            EasyEula.log(Level.WARN, "Agree [Y/n]: ");

            try {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine().toLowerCase().replace(" ", "");

                if (!validInput.contains(input)) return;

                eulaUpdated = true;
                OutputStream outputStream = Files.newOutputStream(eulaFile);
                Properties properties = new Properties();
                properties.setProperty("eula", "true");
                properties.store(outputStream, "By changing the setting below to TRUE you are indicating your agreement to our EULA (https://aka.ms/MinecraftEULA).");
                outputStream.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Inject(method = "isEulaAgreedTo", at = @At("HEAD"), cancellable = true)
    private void isEulaAgreedTo(CallbackInfoReturnable<Boolean> cir) {
        if (eulaUpdated) cir.setReturnValue(true);
    }
}
