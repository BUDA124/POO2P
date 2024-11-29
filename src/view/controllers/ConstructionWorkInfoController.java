package view.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.TextArea;

public class ConstructionWorkInfoController {
    @FXML
    private TextArea textArea;
    private int currentIndex = 0;

    private final String[] texts = {"Obra Civil: Infraestructuras de uso público que son para la comunicación y el transporte, como autopistas, calles e instalaciones de líneas eléctricas. Riesgo: Accidentes de tránsito (por trabajar cerca de vías de circulación), caídas desde alturas en puentes o estructuras, electrocución (por instalación de líneas eléctricas), exposición a vibraciones y ruidos intensos. Prevención: Uso de señalización adecuada y delimitación de zonas de trabajo, equipo de protección personal (arneses en alturas, guantes dieléctricos), coordinación con autoridades de tránsito para desviar o reducir el flujo vehicular cercano, y protección auditiva.",
            "Edificación: Construcción de edificios grandes públicos y privados destinados a diversos usos, incluyendo residenciales, comerciales e industriales. Riesgo: Caídas de altura en estructuras altas, atrapamiento entre materiales de construcción, exposición a polvo y partículas, y riesgos eléctricos al instalar cableado. Prevención: Implementación de barandillas y redes de seguridad en los pisos superiores, uso de sistemas de protección individual contra caídas, equipos de protección respiratoria, y correcta instalación y revisión de sistemas eléctricos.",
            "Obra Residencial: Proyectos orientados a viviendas, como reformas de pisos antiguos o construcción de nuevas viviendas con materiales sustentables. Riesgo: Caídas en espacios reducidos, golpes con herramientas manuales, riesgo de derrumbes al trabajar en reformas de estructuras antiguas, y exposición a materiales tóxicos (pinturas, disolventes). Prevención: Inspección estructural antes de iniciar reformas, uso de herramientas seguras y de protección personal, ventilación adecuada en áreas donde se usan productos químicos, y señalización de áreas de riesgo en reformas.",
            "Obra Industrial: Construcciones llevadas a cabo en fábricas o edificios industriales. Riesgo: Exposición a maquinaria pesada, contacto con sustancias peligrosas, riesgos de incendio o explosión en áreas de fabricación, y problemas ergonómicos por tareas repetitivas. Prevención: Capacitación en el uso de maquinaria, implementación de protocolos de manejo de sustancias peligrosas, sistemas de extinción de incendios, y rotación de tareas para reducir el riesgo de lesiones por movimientos repetitivos.",
            "Obra Comercial: Destinados a la creación de negocios lucrativos, tales como oficinas, restaurantes y tiendas. Riesgo: Caídas y resbalones en espacios interiores, exposición a productos químicos de limpieza, riesgos de incendio, y electrocución al instalar sistemas eléctricos. Prevención: Uso de señalización en áreas húmedas o resbaladizas, almacenamiento seguro de productos químicos, instalación de sistemas de detección de humo y fuego, y revisión del cableado eléctrico por profesionales.",
            "Obra de Construcciones Institucionales: Incluye la construcción de edificios públicos como escuelas, juzgados, hospitales y ministerios, para el funcionamiento de entidades gubernamentales y servicios públicos. Riesgo: Exposición a riesgos biológicos (especialmente en hospitales), caídas al trabajar en estructuras grandes, cortes y golpes con herramientas, y riesgos de fuego en áreas con equipos médicos o electrónicos. Prevención: Uso de equipos de protección biológica (como guantes y mascarillas en hospitales), andamios y sistemas de seguridad en altura, manejo seguro de herramientas, y sistemas de detección y extinción de incendios adaptados para instalaciones públicas.",
            "Obras de Construcción Pública: Son esos trabajos de construcción gestionados por la administración pública, que trabajan las infraestructuras de transporte e instalaciones hidráulicas, urbanas y edificaciones públicas. Riesgo: Riesgos de accidentes vehiculares (por trabajos en zonas de tránsito), exposición a polvo y contaminación, caídas desde alturas en infraestructura urbana, y conflictos con el público. Prevención: Señalización y desvíos de tránsito en áreas de trabajo, equipos de protección respiratoria, sistemas de protección contra caídas, y comunicación efectiva con la comunidad para evitar situaciones de riesgo."};

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
