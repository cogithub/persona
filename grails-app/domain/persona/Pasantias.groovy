package persona


class Pasantias {
    String titulo
    String empresa
    Date fechaInicio
    Date fechaFin
    String descripcion
    Boolean remunerada
    Direccion direccion

    static constraints = {
        titulo blank: false, size: 5..100
        empresa blank: false, size: 3..100
        fechaInicio nullable: false
        fechaFin nullable: true, validator: { val, obj -> 
            if (val && obj.fechaInicio && val.before(obj.fechaInicio)) {
                return "fechaFin.no.puede.ser.anterior.a.fechaInicio"
            }
        }
        descripcion nullable: true, maxSize: 500
        remunerada nullable: false
        direccion nullable: false, blank: false
    }

    String toString() {
        return "${titulo} en ${empresa}"
    }
}
