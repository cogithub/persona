package persona

class Estudio {
    String institucion
    String titulo
    String campoEstudio
    Date fechaInicio
    Date fechaFin
    Boolean actualmenteEstudiando

    static constraints = {
        institucion blank: false, maxSize: 100
        titulo blank: false, maxSize: 100
        campoEstudio nullable: true, maxSize: 100
        fechaInicio nullable: false
        fechaFin nullable: true
        actualmenteEstudiando nullable: false
    }

    String toString() {
        "${titulo} "
    }
}