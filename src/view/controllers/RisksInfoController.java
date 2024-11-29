package view.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.TextArea;

public class RisksInfoController {
    @FXML
    private TextArea textArea;
    private int currentIndex = 0;

    private final String[] texts = {"Riesgos Biológicos: Exposición a bacterias, virus, insectos, reptiles y plantas que tienen potencial de peligro.\n" +
            "Prevenciones:\n" +
            "a) Control de Plagas.\n" +
            "b) Higiene en la zona y trabajadores.\n" +
            "c) Protección Física.",
    "Caídas: Las caídas representan el 40 % de las muertes entre los trabajadores de la construcción, siendo el mayor peligro.\n" +
            "Prevenciones:\n" +
            "a) Protección contra caídas como arneses y cascos al trabajar en alturas.\n" +
            "b) Inspección de los equipos de protección contra caídas.\n" +
            "c) Medidas de prevención en superficies de trabajo seguras.\n" +
            "d) Inspección constante de barandas, conectores y tablones para detectar daños y herramientas también.\n",
    "Lesiones por Golpes: Las lesiones por golpes pueden ser causadas por objetos y malas prácticas.\n" +
            "Prevenciones:\n" +
            "a) Uso de protección.\n" +
            "b) Mantenimiento adecuado de maquinaria.\n" +
            "c) Implementación de sistemas de señalización.\n" +
            "d) Uso de ropa de alta visibilidad y EPP adecuado.\n" +
            "e) Implementación de barreras de protección y planes de control de tráfico en la obra. \n",
    "Peligros de Electricidad: Los peligros eléctricos incluyen el contacto con cables, objetos electrificados y el mal manejo de conexiones.\n" +
            "Prevenciones:\n" +
            "a) Mantener distancias y usar equipos aislantes.\n" +
            "b) Asegurar instalaciones eléctricas.\n" +
            "c) Evitar condiciones peligrosas.\n",
    ". Riesgos Físicos: Incluyen exposición a ruidos, temperaturas y vibraciones.\n" +
            "Prevenciones:\n" +
            "a) Uso de protectores auditivos.\n" +
            "b) Control de Temperaturas.\n" +
            "c) Uso de herramientas y maquinaria con sistemas de amortiguación.\n",
    " Riesgos Ergonómicos:\u2028Relacionados con la manipulación manual de cargas, posturas forzadas y tareas repetitivas.\n" +
            "Prevenciones:\n" +
            "a) Ayudas mecánicas como carretillas y montacargas.\n" +
            "b) Uso de herramientas que reduzcan el esfuerzo físico y minimicen el riesgo de lesiones.\n",
    "Riesgos Químicos:\u2028Exposición a productos químicos como disolventes, pinturas, cemento, etcétera.\n" +
            "Prevenciones:\n" +
            "a) Uso de guantes, mascarillas y protección en los ojos al manipular sustancias químicas.\n" +
            "b) Almacenamiento de productos químicos en lugares seguros.\n" +
            "c) Implementación de sistemas de ventilación en áreas donde se manipulan productos químicos.\n"};

    @FXML
    private void handleNextButton() {
        System.out.println("El botón 'Next' fue presionado.");

        if (textArea == null) {
            System.err.println("El TextArea no está inicializado. Revisa el fx:id o el controlador.");
            return;
        }
        currentIndex = (currentIndex + 1) % texts.length;
        textArea.setText(texts[currentIndex]);
    }

    @FXML
    private void returnImageHandler() {
        SceneController.changeScene("/view/scenes/informationMenuWindow.fxml");
    }
}
