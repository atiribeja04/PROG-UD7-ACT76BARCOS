package prog.ud7.act76barcos;

import java.util.StringTokenizer;

public class Data {

    private int dia;

    private int mes;

    private int any;

    private static final String[] DIES_TEXT = new String[]{"diumenge", "dilluns", "dimarts", "dimecres", "dijous", "divendres",
        "dissabte"};

    private static final String[] MESOS_TEXT = new String[]{"gener", "febrer", "març", "abril", "maig", "juny",
        "juliol", "agost", "setembre", "octubre", "novembre", "desembre"};

    /**
     * Constructor por defecto Inicializa una fecha a dia 1-1-1970
     */
    public Data() {
        this(1, 1, 1970);

    }

    /**
     * Inicializa la fecha
     *
     * @param dia de la semana
     * @param mes del año
     * @param anyo
     */
    public Data(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    /**
     * Inicializa la fecha a partir de otra pasada en formato String dd/mm/yyyy
     *
     * Deberemos trocearlas de forma que asignemos el día més y año a cada uno
     * de los atributoe
     *
     * @param fecha
     */
    public Data(String data) {
        StringTokenizer st = new StringTokenizer(data, "/");
        if (st.countTokens() == 3) {
            try {
                this.dia = Integer.parseInt(st.nextToken());
                this.mes = Integer.parseInt(st.nextToken());
                this.any = Integer.parseInt(st.nextToken());
            } catch (NumberFormatException e) {
                System.err.println("Error al convertir la cadena a números enteros.");
            }
        } else {
            System.err.println("Formato de fecha incorrecto. Se esperan tres componentes separados por '/'.");
        }
    }

    /**
     * Modifica la fecha actual a partir de los datos pasados como argumento
     */
    public void set(int dia, int mes, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.any = anyo;
    }

    /**
     * Obtiene una fecha con los mismos atributos que la fecha actual
     *
     * @return
     */
    public Data clone() {
        Data clon = new Data(this.dia, this.mes, this.any);
        return clon;
    }

    /**
     * Devuelve el día de la semana que representa por la Fecha actual
     *
     * @return @dia
     */
    public int getDia() {
        return this.dia;
    }

    /**
     * Devuelve el mes que representa la Fecha actual
     *
     * @return @mes
     */
    public int getMes() {
        return this.mes;
    }

    /**
     * Devuelve el año que representa la Fecha actual
     *
     * @return @mes
     */
    public int getAny() {
        return this.any;
    }

    /**
     * Muestra por pantalla la fecha en formato español dd-mm-yyyy
     */
    public void mostrarEnFormatES() {
        System.out.printf("%02d-%02d-%d", this.dia, this.mes, this.any);
    }

    /**
     * Muestra por pantalla la fecha en formato inglés yyyy-mm-dd
     */
    public void mostrarEnFormatGB() {
        System.out.printf("%d-%02d-%02d", this.any, this.mes, this.dia);
    }

    /**
     * Muestra por pantalla la fecha en formato texto dd-mmmm-yyyy Ej. 1 enero
     * de 1970
     */
    public void mostrarEnFormatText() {
        String mes = MESOS_TEXT[this.mes];
        System.out.printf("%02d-%n-%d", this.mes, mes, this.any);
    }

    /**
     * Retorna un booleano indicando si la fecha del objeto es igual a la fecha
     * pasada como argumento
     *
     * @return boolean
     */
    public boolean isIgual(Data otraFecha) {
        if (this.dia == otraFecha.dia && this.mes == otraFecha.mes && this.any == otraFecha.any) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna el dia correspondiente de la semana en formato String
     *
     * @return String
     */
    public String getDiaSetmana() {
        return null;
    }

    /**
     * Solo Festivo sábado o domingo
     *
     * @return boolean
     */
    public boolean isFestiu() {
        // ni idea
        return false;
    }

    /**
     * Devuelve el número de la semana dentro del año actual.
     *
     * @return int dia semana
     */
    public int getNumeroSetmana() {
       // ni idea
       return 0;
    }

    /**
     * Devuelve un objeto de tipo fecha que representa una fecha añadiendo
     * @numDias A la fecha Actual. El número máximo de dias a restar es 30
     *
     * @return boolean
     */
    public Data afegir(int numDias) {
    int diaNuevo = this.dia + numDias;
    int mesNuevo = this.mes;
    int anyoNuevo = this.any;

    while (diaNuevo > getDiesMes(mesNuevo, anyoNuevo)) {
        diaNuevo -= getDiesMes(mesNuevo, anyoNuevo);
        mesNuevo++;
        if (mesNuevo > 12) {
            mesNuevo = 1;
            anyoNuevo++;
        }
    }

    return new Data(diaNuevo, mesNuevo, anyoNuevo);
}

    /**
     * Devuelve un objeto de tipo fecha que representa una fecha restando
     * @numDias A la fecha Actual. El número máximo de dias a restar es 30
     *
     * @return boolean
     */
    public Data restar(int numDias) {
    int diaNuevo = this.dia - numDias;
    int mesNuevo = this.mes;
    int anyoNuevo = this.any;

    while (diaNuevo <= 0) {
        if (mesNuevo == 1) {
            mesNuevo = 12;
            anyoNuevo--;
        } else {
            mesNuevo--;
        }
        diaNuevo += getDiesMes(mesNuevo, anyoNuevo);
    }

    return new Data(diaNuevo, mesNuevo, anyoNuevo);
}

    public boolean isCorrecta() {
    if (any <= 0) {
        return false;
    }

    if (mes < 1 || mes > 12) {
        return false;
    }
    
    if (dia < 1 || dia > getDiesMes(mes, any)) {
        return false;
    }

    return true;
}

    /**
     * Retorna el mes del año en formato text (enero, febrero, marzo,...)
     *
     * @return char
     */
    private String getMesEnFormatText() {
        return MESOS_TEXT[mes - 1];
    }

    /**
     * Devuelve el número de dias transcurridos desde el 1-1-1
     *
     * @return int
     */
    private int getDiesTranscorregutsOrigen() {
    int diasTranscurridos = 0;
    
    for (int i = 1; i < any; i++) {
        if (isBisiesto(i)) {
            diasTranscurridos += 366;
        } else {
            diasTranscurridos += 365;
        }
    }
    for (int i = 1; i < mes; i++) {
        diasTranscurridos += getDiesMes(i, any);
    }
    diasTranscurridos += dia - 1;

    return diasTranscurridos;
}

    /**
     * Devuelve el número de dias transcurridos en el anyo que representa el
     * objeto
     *
     * @return int
     */
    private int getDiesTranscorregutsEnAny() {
    int diasTranscurridos = dia - 1;
    
    for (int i = 1; i < mes; i++) {
        diasTranscurridos += getDiesMes(i, any);
    }

    return diasTranscurridos;
}
    /**
     * Indica si el año pasado como argumento es bisiesto. Un año es bisiesto si
     * es divisible por 4 pero no es divisible entre 100 o es divisible entre 4
     * entre 100 y entre 400
     *
     * @return boolean
     */
    public static boolean isBisiesto(int anyo) {
        if ((anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 4 == 0 && anyo % 100 == 0 && anyo % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calcula el número de días que tiene el @mes en el @año pasado como
     * argumento Deberás hacer uso del métodos isBisiesto
     *
     * @return int total dias mes en curso
     */
    public static int getDiesMes(int mes, int anyo) {
        int[] mesesCon30Dias = new int[]{4, 6, 9, 11};
        int[] mesesCon31Dias = new int[]{1, 3, 5, 7, 8, 10, 12};
        if (contiene(mesesCon30Dias, mes)) {
            return 30;
        } else if (contiene(mesesCon31Dias, mes)) {
            return 31;
        } else {
            if (mes == 2 && isBisiesto(anyo) == true) {
                return 29;
            } else {
                return 28;
            }
        }
    }

    private static boolean contiene(int[] array, int valor) {
        for (int valorDeseado : array) {
            if (valorDeseado == valor) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calcula el número total de dias que tiene el año pasado como argumento
     *
     * @return int total dias anyo en curso
     */
    public static int getDiesAny(int anyo) {
        if (isBisiesto(anyo)) {
            return 366;
        } else {
            return 365;
        }
    }
}