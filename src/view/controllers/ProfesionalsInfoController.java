package view.controllers;

import javafx.fxml.FXML;


import javafx.scene.control.TextArea;

public class ProfesionalsInfoController {
    @FXML
    private TextArea textArea;
    private int currentIndex = 0;

    private final String[] texts = {"Albañil: Representan el 3 % del sector. Ellos se encargan de la \n" +
            "preparación y montaje de encofrados para hormigón, vertido y nivelación de hormigón en estructuras y asegurar la correcta curación y fraguado del hormigón para garantizar la calidad de las obras. Riesgo: Esfuerzo físico excesivo, caídas desde alturas, exposición a condiciones climáticas extremas, manipulación de herramientas pesadas y riesgo de lesiones musculares. Prevención: Uso de equipo de protección personal adecuado, como casco, guantes y arneses de seguridad al trabajar en alturas y capacitación en el manejo seguro de herramientas pesadas.\n",
            "Peones de Construcción de Edificios: Representan el 16.5 % del total de trabajadores en construcción. Realizan las tareas auxiliares en la construcción y asistencia a otros equipos de construcción, facilitando el desarrollo de las tareas principales, recogiendo escombros, cargar y transportar materiales, controlar maquinaria de carga y eliminar residuos peligrosos como asbesto o plomo y preparar cemento para su uso en la obra son buenos ejemplos que también ayudan a visualizar las herramientas y ambientes que tienden a encontrarse. Riesgo: Exposición a polvo y materiales peligrosos (como asbesto), esfuerzo físico en la carga de materiales, riesgo de atropello por maquinaria y caídas al limpiar o preparar áreas de trabajo. Prevención: Uso de mascarillas y gafas de protección contra el polvo, guantes y calzado de seguridad para evitar cortes y lesiones, capacitación en la manipulación de materiales peligrosos, y delimitación de áreas de trabajo para evitar accidentes con maquinaria.",
            "Electricistas y afines: Ocupan el 4 % de los puestos en el sector y continúan creciendo en los últimos años. Se encargan de la instalación y mantenimiento de sistemas eléctricos en edificaciones y asegurar el cumplimiento de normas de seguridad eléctrica para prevenir accidentes, como también supervisar el funcionamiento de instalaciones eléctricas y resolver fallos técnicos. Riesgo: Electrocución, caídas al trabajar en altura, incendios por cortocircuitos y riesgo de quemaduras. Prevención: Uso de equipo de protección dieléctrico (guantes, botas aislantes), capacitación en el trabajo seguro con electricidad, procedimientos de bloqueo y etiquetado (LOTO), y herramientas aisladas. Además, inspección regular de equipos eléctricos.",
            "Pintores y Empapeladores: Constituyen el 3.3 % de los puestos. Son responsables del ecubrimiento de superficies con pintura y papel tapiz y de la preparación de superficies antes de aplicar los recubrimientos. Riesgo: Exposición a vapores de pinturas y disolventes, riesgo de caídas al trabajar en alturas, y contacto con materiales irritantes. Prevención: Uso de mascarillas para vapores, gafas y guantes de protección, uso de arneses de seguridad cuando trabajen en altura, y ventilación adecuada en espacios cerrados para minimizar la inhalación de vapores tóxicos.", "Encofradores y Operarios de Hormigón: Representan el 3 % del sector. Ellos se encargan de la preparación y montaje de encofrados para hormigón, vertido y nivelación de hormigón en estructuras y asegurar la correcta curación y fraguado del hormigón para garantizar la calidad de las obras. Riesgo: Caídas al colocar y retirar encofrados, riesgo de atrapamiento de manos en moldes o equipos de hormigón, exposición a polvo y riesgo de fracturas por manipulación de hormigón. Prevención: Uso de EPP como guantes, botas de seguridad y arneses, capacitación en el uso de encofrados y equipos de hormigón, y asegurarse de que las superficies de trabajo estén niveladas y libres de obstáculos.",
            "Oficiales, Operarios y Artesanos de Otros Oficios: Constituyen el 2.4 % de los trabajadores, con un aumento del 5.3 % el último año. Ellos realizan las tareas especializadas según el oficio, como carpintería, fontanería, etc. Se encargan del soporte en diferentes fases de la construcción, adaptándose a las necesidades específicas del proyecto. Riesgo: Lesiones al operar herramientas eléctricas y manuales, riesgo de caídas o resbalones en obras, y exposición a materiales tóxicos o irritantes. Prevención: Capacitación en el uso seguro de herramientas y máquinas, uso de equipo de protección personal adecuado (casco, guantes, gafas, botas antideslizantes), y limpieza regular del área de trabajo para evitar accidentes.",
            "Montadores de Estructuras Metálicas: Ocupan el 2.1 % de los empleados, con un aumento del 7.2 % desde el año pasado. Sus responsabilidades son el montaje y fijación de estructuras metálicas en proyectos de construcción, la coordinación con otros equipos para asegurar la correcta instalación de componentes metálicos y la verificación de la integridad y alineación de las estructuras montadas. Riesgo: Caídas de altura, golpes con componentes metálicos, atrapamiento de dedos y manos, y riesgo de lesiones al manipular piezas pesadas. Prevención: Uso de arneses y líneas de vida en altura, guantes de protección y casco, entrenamiento en técnicas de levantamiento seguro, y supervisión constante para asegurar el correcto ensamblaje de las estructuras."};

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
