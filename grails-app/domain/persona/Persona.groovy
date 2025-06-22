package persona


class Persona {
    String nombre
    Estudio estudio
    Profesion profesion
    String apellido
    String rut
    Date fechaNacimiento
    String direccion
    String telefono
    String email

    static constraints = {
        nombre blank: false, size: 2..50
        estudio nullable: false, blank: false
        profesion nullable: false
        apellido blank: false, size: 2..50
        rut blank: true, unique: true
        fechaNacimiento nullable: false
        direccion nullable: true, widget: 'textarea'
        telefono nullable: true, maxSize: 100
        email nullable: true, email: true
    }

    String toString() {
        return "${nombre} ${apellido}"
    }
}
