//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package models.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CustomSafetyGuide extends SafetyGuide implements Serializable {
    private static final long serialVersionUID = 1L; // Versión para evitar problemas de compatibilidad

    private List<String> areasDeTrabajo = new ArrayList();
    private List<String> profesionales = new ArrayList();
    private List<String> herramientas = new ArrayList();
    private transient Scanner scanner = new Scanner(System.in);

    public CustomSafetyGuide() {
        this.defineProjectTitle();
        this.seleccionarAreasDeTrabajo();
        this.seleccionarProfesionales();
        this.seleccionarHerramientas();
        this.generarRiesgosPersonalizados();
        this.generarChecklist();
    }

    private void inicializarScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    private void defineProjectTitle() {
        System.out.print("\nDefina un título para su proyecto: ");
        super.setTitle(scanner.nextLine());
    }

    private void mostrarAreasTrabajo() {
        System.out.println("\n=== Áreas de trabajo ===");
        System.out.println("1. Obra Civil");
        System.out.println("2. Edificación");
        System.out.println("3. Obra Residencial");
        System.out.println("4. Obra Industrial");
        System.out.println("5. Obra Comercial");
        System.out.println("6. Construcciones Institucionales");
        System.out.println("7. Construcción Pública");
        System.out.print("Ingrese el número de la opción o '0' para finalizar: ");
    }
    private void seleccionarAreasDeTrabajo() {
        inicializarScanner();
        this.areasDeTrabajo.clear();

        while (true) {
            mostrarAreasTrabajo();
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                    case "0":
                        if (this.areasDeTrabajo.isEmpty()) {
                            System.out.println("Debe de elegir al menos un área de trabajo antes de finalizar.");
                            break;
                        } else {
                            return;
                        }
                    case "1":
                        this.areasDeTrabajo.add("Obra Civil");
                        System.out.println("Agregado: Obra Civil");
                        break;
                    case "2":
                        this.areasDeTrabajo.add("Edificación");
                        System.out.println("Agregado: Edificación");
                        break;
                    case "3":
                        this.areasDeTrabajo.add("Obra Residencial");
                        System.out.println("Agregado: Obra Residencial");
                        break;
                    case "4":
                        this.areasDeTrabajo.add("Obra Industrial");
                        System.out.println("Agregado: Obra Industrial");
                        break;
                    case "5":
                        this.areasDeTrabajo.add("Obra Comercial");
                        System.out.println("Agregado: Obra Comercial");
                        break;
                    case "6":
                        this.areasDeTrabajo.add("Construcciones Institucionales");
                        System.out.println("Agregado: Construcciones Institucionales");
                        break;
                    case "7":
                        this.areasDeTrabajo.add("Construcción Pública");
                        System.out.println("Agregado: Construcción Pública");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, intente de nuevo.");
                }
        }
    }

    private void mostrarProfesionales() {
        System.out.println("\n=== Profesionales ===");
        System.out.println("1. Albañil");
        System.out.println("2. Peones de Construcción de Edificios");
        System.out.println("3. Electricistas de la Construcción y Afines");
        System.out.println("4. Pintores y Empapeladores");
        System.out.println("5. Encofradores y Operarios de Hormigón");
        System.out.println("6. Oficiales, Operarios y Artesanos de Otros Oficios");
        System.out.println("7. Montadores de Estructuras Metálicas");
        System.out.print("Ingrese el número de la opción o '0' para finalizar: ");
    }

    private void seleccionarProfesionales() {
        inicializarScanner();
        this.profesionales.clear();

        while (true) {
            mostrarProfesionales();
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "0":
                    if (this.profesionales.isEmpty()) {
                        System.out.println("Debe seleccionar al menos un profesional antes de finalizar.");
                        break;
                    } else {
                        return;
                    }
                case "1":
                    this.profesionales.add("Albañil");
                    System.out.println("Agregado: Albañil");
                    break;
                case "2":
                    this.profesionales.add("Peones de Construcción de Edificios");
                    System.out.println("Agregado: Peones de Construcción de Edificios");
                    break;
                case "3":
                    this.profesionales.add("Electricistas de la Construcción y Afines");
                    System.out.println("Agregado: Electricistas de la Construcción y Afines");
                    break;
                case "4":
                    this.profesionales.add("Pintores y Empapeladores");
                    System.out.println("Agregado: Pintores y Empapeladores");
                    break;
                case "5":
                    this.profesionales.add("Encofradores y Operarios de Hormigón");
                    System.out.println("Agregado: Encofradores y Operarios de Hormigón");
                    break;
                case "6":
                    this.profesionales.add("Oficiales, Operarios y Artesanos de Otros Oficios");
                    System.out.println("Agregado: Oficiales, Operarios y Artesanos de Otros Oficios");
                    break;
                case "7":
                    this.profesionales.add("Montadores de Estructuras Metálicas");
                    System.out.println("Agregado: Montadores de Estructuras Metálicas");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }

            // Verificar si se seleccionó el máximo permitido.
            if (this.profesionales.size() == 7) {
                System.out.println("Se ha alcanzado el número máximo de profesionales seleccionados (7).");
                break;
            }
        }
    }

    private void mostrarHerramientas() {
        System.out.println("\n=== Herramientas ===");
        System.out.println("1. Generador Eléctrico");
        System.out.println("2. Hormigonera");
        System.out.println("3. Placa Compactadora");
        System.out.println("4. Carretilla Elevadora");
        System.out.println("5. Pistola de Clavos");
        System.out.println("6. Nivel y/o Destornillador");
        System.out.println("7. Llaves, Pinzas y/o Remachadora");
        System.out.println("8. Serrucho, Pala y/o Martillo");
        System.out.println("9. Taladro y/o Amoladora");
        System.out.print("Ingrese el número de la opción o '0' para finalizar: ");
    }

    private void seleccionarHerramientas() {
        inicializarScanner();
        this.herramientas.clear();

        while (true) {
            mostrarHerramientas();
            String opcion = scanner.nextLine().trim();

            if (opcion.equals("0")) {
                if (this.herramientas.isEmpty()) {
                    System.out.println("Debe seleccionar al menos una herramienta antes de finalizar.");
                } else {
                    System.out.println("Selección finalizada.");
                    break;
                }
            }

            switch (opcion) {
                case "1":
                    this.herramientas.add("Generador Eléctrico");
                    System.out.println("Agregado: Generador Eléctrico");
                    break;
                case "2":
                    this.herramientas.add("Hormigonera");
                    System.out.println("Agregado: Hormigonera");
                    break;
                case "3":
                    this.herramientas.add("Placa Compactadora");
                    System.out.println("Agregado: Placa Compactadora");
                    break;
                case "4":
                    this.herramientas.add("Carretilla Elevadora");
                    System.out.println("Agregado: Carretilla Elevadora");
                    break;
                case "5":
                    this.herramientas.add("Pistola de Clavos");
                    System.out.println("Agregado: Pistola de Clavos");
                    break;
                case "6":
                    this.herramientas.add("Nivel y/o Destornillador");
                    System.out.println("Agregado: Nivel y/o Destornillador");
                    break;
                case "7":
                    this.herramientas.add("Llaves, Pinzas y/o Remachadora");
                    System.out.println("Agregado: Llaves, Pinzas y/o Remachadora");
                    break;
                case "8":
                    this.herramientas.add("Serrucho, Pala y/o Martillo");
                    System.out.println("Agregado: Serrucho, Pala y/o Martillo");
                    break;
                case "9":
                    this.herramientas.add("Taladro y/o Amoladora");
                    System.out.println("Agregado: Taladro y/o Amoladora");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }

            // Verificar si se alcanzó el máximo permitido.
            if (this.herramientas.size() == 9) {
                System.out.println("Se ha alcanzado el número máximo de herramientas seleccionadas (9).");
                break;
            }
        }
    }

    private void generarRiesgosPersonalizados() {
        inicializarScanner();
        Iterator var1 = this.herramientas.iterator();

        while(var1.hasNext()) {
            switch ((String)var1.next()) {
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

        var1 = this.profesionales.iterator();

        while(var1.hasNext()) {
            switch ((String)var1.next()) {
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

        var1 = this.areasDeTrabajo.iterator();

        while(var1.hasNext()) {
            switch ((String)var1.next()) {
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
}
