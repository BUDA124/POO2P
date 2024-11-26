package models.general;

public class BasicSafetyGuide extends SafetyGuide {
    public BasicSafetyGuide() {
        this.cargarRiesgosYPrevencionesBasicos();
        this.generarChecklist();
    }

    private void cargarRiesgosYPrevencionesBasicos() {
        this.riesgosYPrevenciones.put("Caídas desde altura", "Utilizar arnés y líneas de vida.");
        this.riesgosYPrevenciones.put("Cortes con herramientas", "Usar guantes y equipos de protección.");
        this.riesgosYPrevenciones.put("Exposición a ruidos fuertes", "Utilizar protectores auditivos.");
    }
}