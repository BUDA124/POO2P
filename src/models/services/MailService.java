package models.services;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class MailService {

    public MailService() {}

    private static final String USERNAME = "construccionguiasseguridad@gmail.com";
    private static final String APP_PASSWORD = "xmrnaxgpxzilhnlq";

    // Método genérico para enviar correos
    private void enviarCorreo(String destinatario, String asunto, String contenido) {
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");

        Session sesion = Session.getInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, APP_PASSWORD);
            }
        });

        try {
            Message mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(USERNAME));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject(asunto);
            mensaje.setContent(contenido, "text/html");

            Transport.send(mensaje);
            System.out.println("Correo enviado con éxito a " + destinatario);
        } catch (MessagingException e) {
            System.err.println("Error al enviar el correo: " + e.getMessage());
        }
    }

    // Método para generar contenido HTML
    private String generarContenidoHTML(String saludo, String cuerpo, String detalles) {
        String template = """
            <!DOCTYPE html>
            <html lang="es">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Notificación</title>
                <style>
                    body { font-family: Arial, sans-serif; line-height: 1.6; color: #333; max-width: 600px; margin: 0 auto; padding: 20px; }
                    header { background-color: #4CAF50; color: white; text-align: center; padding: 10px; }
                    h1, h2 { color: #4CAF50; }
                    .content { background-color: #f2f2f2; padding: 15px; border-left: 5px solid #4CAF50; margin-bottom: 20px; }
                    .button { display: inline-block; background-color: #4CAF50; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px; }
                    footer { text-align: center; margin-top: 20px; font-size: 0.8em; color: #777; }
                </style>
            </head>
            <body>
                <header>
                    <h1>Servicio de Guías De Seguridad</h1>
                </header>
                <main>
                    <h2>%s</h2>
                    <p>%s</p>
                    <div class="content">
                        <p>%s</p>
                    </div>
                    <p>Para más información, contáctanos directamente.</p>
                </main>
                <footer>
                    <p>Este es un correo automático. Por favor, no respondas a este mensaje.</p>
                </footer>
            </body>
            </html>
        """;
        return String.format(template, saludo, cuerpo, detalles);
    }

    public void notifyPasswordChange(String destinatario) {
        String saludo = "Notificación de restablecimiento de contraseña";
        String cuerpo = "Se ha solicitado un cambio de contraseña para tu cuenta.";
        String detalles = "Si no fuiste tú quien lo solicitó, comunícate con nosotros inmediatamente a " + USERNAME;
        String contenidoHTML = generarContenidoHTML(saludo, cuerpo, detalles);
        enviarCorreo(destinatario, "Restablecimiento de contraseña", contenidoHTML);
    }

    public void notifyForgottenUsername(String destinatario) {
        String saludo = "Recuperación de nombre de usuario no disponible";
        String cuerpo = "Actualmente no ofrecemos el servicio para restablecer nombres de usuario.";
        String detalles = "Te recomendamos crear una nueva cuenta para acceder a nuestro servicio.";
        String contenidoHTML = generarContenidoHTML(saludo, cuerpo, detalles);
        enviarCorreo(destinatario, "Recuperación de usuario", contenidoHTML);
    }
}
