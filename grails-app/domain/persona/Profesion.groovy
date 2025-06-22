// grails-app/domain/persona/Profesion.groovy
package persona

class Profesion {

    String nombre
    Pasantias pasantias
    String descripcion

    static constraints = {
        nombre unique: true,
               blank: false,
               size: 3..100
        pasantias nullable: false, blank: false
        descripcion nullable: true, maxSize: 500
    }

    /**
     * Sobrescribe el método toString() para proporcionar una representación
     * de cadena más legible de un objeto Profesion.
     */
    @Override
    String toString() {
        return "${nombre} - ${descripcion ?: 'Sin descripción'}"
    }
}