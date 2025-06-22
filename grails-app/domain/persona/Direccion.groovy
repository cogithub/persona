
package persona

class Direccion {
    String calle
    String numero
    String ciudad
    String region
    String pais
    String codigoPostal
    String referencia
    String telefono
    

    static constraints = {
        calle (nullable: false, blank: false)
        numero (nullable: false, blank: false, )
        ciudad (nullable: false, blank: false)
        region (nullable: false, blank: false)
        pais (nullable: false, blank: false)
        codigoPostal (nullable: true, blank: true, )
        referencia (nullable: true, blank: true, maxSize: 255)
        telefono (nullable: true, blank: true, maxSize: 20, )


    }

    String toString() {
        return "${calle} ${numero}, ${ciudad}, ${region}, ${pais}"
    }   
    }