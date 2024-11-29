package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ToolsInfoController {

    @FXML
    private TextArea textArea;
    private int currentIndex = 0;

    private final String[] texts = {"Generador Eléctrico: Fuente de energía esencial para operar maquinaria y herramientas en lugares sin acceso a red eléctrica. Riesgo: Riesgo de electrocución si no se maneja correctamente o si hay exposición a cables dañados y de intoxicación por gases (CO, CO2) en espacios cerrados debido a la combustión del generador. Prevención: Realizar inspecciones periódicas del cableado y conexiones, asegurarse de que los cables estén aislados, en buen estado y en áreas bien ventiladas.",
    "Hormigonera: Máquina utilizada para mezclar y preparar hormigón. Riesgo: Exposición a polvo y partículas, lo cual puede causar problemas respiratorios. Prevención: Usar mascarillas y gafas de protección para evitar inhalar polvo y proteger los ojos.",
    "Placa Compactadora: Herramienta utilizada para compactar suelos y garantizar una base sólida para las estructuras. Riesgo: Ruido excesivo, lo cual puede afectar la audición si no se usan protectores adecuados. Prevención: Usar protectores auditivos adecuados para prevenir daño auditivo.\n",
            "Carretilla Elevadora: Equipamiento utilizado para transportar materiales pesados. Riesgo: Riesgo de atropello, tanto para el operario como para otros trabajadores en la obra. Prevención: Señalizar la zona de trabajo y limitar el acceso de personas no autorizadas cuando la carretilla está en uso.",
    "Nivel y Destornillador: Herramientas para asegurar la alineación y ensamblaje de las estructuras. Riesgo: Riesgo de corte o pinchazo si el destornillador se usa incorrectamente. Prevención: Usar destornilladores adecuados para cada tipo de tornillo y aplicar fuerza moderada para evitar resbalones.",
    "Llaves, Pinzas y Remachadora: Utilizadas para ensamblar componentes y asegurar las estructuras metálicas. Riesgo: Riesgo de atrapamiento o aplastamiento de dedos al ensamblar piezas y de proyección de piezas o fragmentos. Prevención: Usar gafas de seguridad al remachar para protegerse de posibles proyecciones y mantener las manos y dedos alejados de las piezas en movimiento\n",
    "Serrucho, Pala y Martillo: Herramientas manuales para cortar, cavar y golpear materiales. Riesgo: Riesgo de cortes o heridas en las manos por el uso del serrucho, lesiones en la espalda al usar la pala incorrectamente y de golpes en las manos o dedos al manejar el martillo. Prevención: Usar guantes de protección y técnicas adecuadas de levantamiento",
    "Taladro y Amoladora: Equipos eléctricos utilizados para perforar y cortar materiales. Riesgo: Riesgo de proyección de fragmentos y electrocución si no hay aislamiento adecuado. Prevención: Usar gafas y asegurarse de usar el taladro y la amoladora en superficies secas"};

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
