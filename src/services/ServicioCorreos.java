package services;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class ServicioCorreos {

    private static final String USERNAME = "construccionguiasseguridad@gmail.com";
    private static final String APP_PASSWORD = "xmrnaxgpxzilhnlq ";

    // Método para enviar correos
    public void enviarCorreo(String destinatario, String asunto, String contenido) {
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
            e.printStackTrace();
        }
    }

    // Método para generar contenido HTML del correo
    public String generarContenidoHTML(String asuntoCorreo, String nombreCliente, String tipoNotificacion, String detalles) {
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
                    <h2>Estimado/a %s,</h2>
                    <p>%s</p>
                    <div class="content">
                        <h3>%s</h3>
                        <p>%s</p>
                    </div>
                    <p>Para más detalles, ingresa a tu cuenta o contáctanos directamente.</p>
                    <a href="#" class="button">Ver mi cuenta</a>
                </main>
                <footer>
                    <p>Este es un correo automático. Por favor, no respondas a este mensaje.</p>
                </footer>
            </body>
            </html>
        """;
        return String.format(template, nombreCliente, asuntoCorreo, tipoNotificacion, detalles);
    }

    public void enviarNotificacion(String destinatario, String nombreCliente) {
        String asunto = "Bienvenido a nuestro servicio";
        String asuntoCorreo = "Gracias por registrarte en nuestro sistema.";
        String tipoNotificacion = "Registro exitoso";
        String detalles = "Tu cuenta ha sido activada correctamente.";

        String contenidoHTML = generarContenidoHTML(asuntoCorreo, nombreCliente, tipoNotificacion, detalles);
        enviarCorreo(destinatario, asunto, contenidoHTML);
    }
}
