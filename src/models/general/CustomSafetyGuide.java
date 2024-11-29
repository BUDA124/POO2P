package models.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomSafetyGuide extends SafetyGuide implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<String> areasDeTrabajo = new ArrayList<>();
    private List<String> profesionales = new ArrayList<>();
    private List<String> herramientas = new ArrayList<>();

    // Constructor que recibe las selecciones
    public CustomSafetyGuide(List<String> areasDeTrabajo, List<String> profesionales, List<String> herramientas) {
        super.setTitle("Guía de Seguridad Personalizada");
        this.areasDeTrabajo = new ArrayList<>(areasDeTrabajo);
        this.profesionales = new ArrayList<>(profesionales);
        this.herramientas = new ArrayList<>(herramientas);
        this.generarRiesgosPersonalizados();
        this.generarChecklist();
    }

    private void generarRiesgosPersonalizados() {
        for (String herramienta : herramientas) {
            switch (herramienta) {
                case "Generador Eléctrico":
                    this.riesgosYPrevenciones.put("Riesgo de electrocución y gases tóxicos con Generador Eléctrico", "Realizar inspecciones periódicas y asegurar buena ventilación.");
                    break;
                case "Hormigonera":
                    this.riesgosYPrevenciones.put("Exposición a polvo y partículas con Hormigonera", "Usar mascarillas y gafas de protección.");
                    break;
                case "Placa Compactadora":
                    this.riesgosYPrevenciones.put("Riesgo de daño auditivo con Placa Compactadora", "Usar protectores auditivos adecuados.");
                    break;
                case "Carretilla Elevadora":
                    this.riesgosYPrevenciones.put("Riesgo de atropello con Carretilla Elevadora", "Señalizar la zona de trabajo y limitar el acceso.");
                    break;
                case "Taladro y/o Amoladora":
                    this.riesgosYPrevenciones.put("Riesgo de proyección de fragmentos y electrocución con Taladro y Amoladora", "Usar gafas y trabajar en superficies secas.");
                    break;
                case "Llaves, Pinzas y/o Remachadora":
                    this.riesgosYPrevenciones.put("Riesgo de atrapamiento con Llaves y Remachadora", "Usar gafas de seguridad y mantener las manos alejadas de las piezas en movimiento.");
                    break;
                case "Serrucho, Pala y/o Martillo":
                    this.riesgosYPrevenciones.put("Riesgo de cortes y golpes con Serrucho, Pala y Martillo", "Usar guantes de protección y técnicas adecuadas.");
                    break;
                case "Nivel y/o Destornillador":
                    this.riesgosYPrevenciones.put("Riesgo de corte con Nivel y Destornillador", "Usar herramientas adecuadas y aplicar fuerza moderada.");
            }
        }

        for (String profesional : profesionales) {
            switch (profesional) {
                case "Albañil":
                    this.riesgosYPrevenciones.put("Riesgo de esfuerzo físico y caídas para Albañiles", "Usar equipo de protección personal adecuado y capacitación en manejo de herramientas pesadas.");
                    break;
                case "Peones de Construcción de Edificios":
                    this.riesgosYPrevenciones.put("Exposición a polvo y atropellos para Peones de Construcción", "Usar mascarillas, gafas y delimitar áreas de trabajo.");
                    break;
                case "Electricistas de la Construcción y Afines":
                    this.riesgosYPrevenciones.put("Electrocución e incendios para Electricistas", "Usar equipo dieléctrico, herramientas aisladas y seguir procedimientos de bloqueo y etiquetado (LOTO).");
                    break;
                case "Pintores y Empapeladores":
                    this.riesgosYPrevenciones.put("Exposición a vapores tóxicos y caídas para Pintores", "Usar mascarillas para vapores, gafas, guantes y ventilación adecuada.");
                    break;
                case "Encofradores y Operarios de Hormigón":
                    this.riesgosYPrevenciones.put("Riesgo de atrapamiento y fracturas para Encofradores", "Usar EPP adecuado y asegurar superficies niveladas.");
                    break;
                case "Oficiales, Operarios y Artesanos de Otros Oficios":
                    this.riesgosYPrevenciones.put("Riesgo de lesiones con herramientas eléctricas y manuales para Oficiales", "Capacitación en uso seguro de herramientas y uso de equipo de protección personal.");
                    break;
                case "Montadores de Estructuras Metálicas":
                    this.riesgosYPrevenciones.put("Caídas y atrapamiento para Montadores de Estructuras Metálicas", "Usar arneses, guantes y supervisión constante.");
            }
        }

        for (String area : areasDeTrabajo) {
            switch (area) {
                case "Obra Civil":
                    this.riesgosYPrevenciones.put("Riesgos generales en Obra Civil", "Seguir protocolos de seguridad y capacitación adecuada.");
                    break;
                case "Edificación":
                    this.riesgosYPrevenciones.put("Riesgo de caída de materiales en Edificación", "Usar casco y señalizar las áreas de trabajo.");
                    break;
                case "Obra Residencial":
                    this.riesgosYPrevenciones.put("Exposición a polvo y ruido en Obra Residencial", "Usar mascarillas y protectores auditivos.");
                    break;
                case "Obra Industrial":
                    this.riesgosYPrevenciones.put("Riesgo de contacto con maquinaria pesada en Obra Industrial", "Capacitación en maquinaria y delimitación de áreas peligrosas.");
                    break;
                case "Obra Comercial":
                    this.riesgosYPrevenciones.put("Riesgo de caídas y lesiones en Obra Comercial", "Asegurar superficies y uso de equipo de protección personal.");
                    break;
                case "Construcciones Institucionales":
                    this.riesgosYPrevenciones.put("Riesgos generales en Construcciones Institucionales", "Implementar medidas de seguridad estándar.");
                    break;
                case "Construcción Pública":
                    this.riesgosYPrevenciones.put("Riesgo de exposición a tráfico en Construcción Pública", "Delimitar áreas de trabajo y usar señalización adecuada.");
            }
        }
    }

    public void mostrarRiesgosPersonalizados() {
        System.out.println("\n=== Riesgos y Prevenciones Personalizados ===");
        super.mostrarRiesgosYPrevenciones();
    }

    public List<String> getAreasDeTrabajo() {
        return areasDeTrabajo;
    }

    public List<String> getProfesionales() {
        return profesionales;
    }

    public List<String> getHerramientas() {
        return herramientas;
    }
}
