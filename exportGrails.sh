echo ""
echo ""
echo ""

export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
java -version

echo ""
echo ""
echo ""

export PATH=$PATH:"/Users/carlosocando/Downloads/grails/grails-5.2.3/bin"

case $1 in
  a)
    echo "*** solo grails ->vsin run"
    grails -v
    grails
    ;;
  b)
    echo "*** Run y debug"
    grails -v
    grails run-app --stacktrace
    ;;
  x)
    echo "*bb ** Run y debug bb"
    grails -v
    grails run-app --verbose
    ;;
  c)
    echo "*** Grails -> Crear un nuevo proyecto"
    grails -v
    grails create-app
    ;;
  *)
    echo "*** Ningun opción válida seleccionada"
    grails -v
    exit 1
    ;;
esac

# open http://localhost:8080/persona

echo ""
echo ""
echo ""