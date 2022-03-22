package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String saida = "";
        Scanner in = new Scanner(System.in);
        String entrada = in.nextLine();
      //String entrada = "aux2 := (aux == 2) * 200 / 19";
        //Scanner in = new Scanner(new FileReader("dados.txt"));
        //while (in.hasNextLine()) {
        //    String entrada = scanner.nextLine();
        //    System.out.println(line);
        //}

        entrada = entrada.replace(" ","");

        String[] tst = entrada.split("");

        String aux="";
        String regexIdent="[a-z]+";
        String acumuladorIdent="";
        String regexNumeric="[0-9]+";
        String acumuladorNumerico="";
        ArrayList<String> numeros = new ArrayList<String>();
        
        for (String a: tst) {
         // System.out.println("entra loop>  " +a);

          
             if(aux.equals(":") && a.equals("=")){
                a = ":=";
                aux = "";
            }
            if(a.equals(":")){
                aux = ":";
            }
            if(aux.equals("=") && a.equals("=")){
                a = "==";
                aux = "";
            }
            if(a.equals("=")){
                aux = "=";
            }

            if (acumuladorIdent.length()==0) {
                if (a.matches(regexNumeric)) {
                    acumuladorNumerico += a;
                }
            }
            else{
                if (a.matches(regexNumeric)) {
                    acumuladorIdent += a;
                }
            }
            if(a.matches(regexIdent) && acumuladorNumerico.length()==0){
                acumuladorIdent+=a;
            }
            else if(a.matches(regexIdent) && acumuladorNumerico.length()!=0){
                acumuladorNumerico="";
            }


            switch (a) {
                case ":=":
                    if(acumuladorNumerico.length()!=0) {
                        saida += "('" + acumuladorNumerico + "', INT_LIT,2)\n";
                        acumuladorNumerico = "";
                    }
                    if(acumuladorIdent.length()!=0) {
                        saida += "('" + acumuladorIdent + "', IDENT, 1)\n";
                        acumuladorIdent = "";
                    }
                    saida+="(':=', ASSIGN_OP, 12)\n";
                    aux="";
                    break;
                case "==":
                    if(acumuladorNumerico.length()!=0) {
                        saida += "('" + acumuladorNumerico + "', INT_LIT,2)\n";
                        acumuladorNumerico = "";
                    }
                    if(acumuladorIdent.length()!=0) {
                        saida += "('" + acumuladorIdent + "', IDENT, 1)\n";
                        acumuladorIdent = "";
                    }
                    saida+="('==', EQ_OP, 11)\n";
                    break;
                case "<":
                    if(acumuladorNumerico.length()!=0) {
                        saida += "('" + acumuladorNumerico + "', INT_LIT,2)\n";
                        acumuladorNumerico = "";
                    }
                    if(acumuladorIdent.length()!=0) {
                        saida += "('" + acumuladorIdent + "', IDENT, 1)\n";
                        acumuladorIdent = "";
                    }
                    saida+="('<', LT_OP, 10)\n";
                    break;
                case "/":
                    if(acumuladorNumerico.length()!=0) {
                        saida += "('" + acumuladorNumerico + "', INT_LIT,2)\n";
                        acumuladorNumerico = "";
                    }
                    if(acumuladorIdent.length()!=0) {
                        saida += "('" + acumuladorIdent + "', IDENT, 1)\n";
                        acumuladorIdent = "";
                    }
                    saida+="('/', DIV_OP, 8)\n";
                    break;
                case "*":
                    if(acumuladorNumerico.length()!=0) {
                        saida += "('" + acumuladorNumerico + "', INT_LIT,2)\n";
                        acumuladorNumerico = "";
                    }
                    if(acumuladorIdent.length()!=0) {
                        saida += "('" + acumuladorIdent + "', IDENT, 1)\n";
                        acumuladorIdent = "";
                    }
                    saida+="('*', MUL_OP, 7)\n";
                    break;
                case "-":
                    if(acumuladorNumerico.length()!=0) {
                        saida += "('" + acumuladorNumerico + "', INT_LIT,2)\n";
                        acumuladorNumerico = "";
                    }
                    if(acumuladorIdent.length()!=0) {
                        saida += "('" + acumuladorIdent + "', IDENT, 1)\n";
                        acumuladorIdent = "";
                    }
                    saida+="('-', SUB_OP, 6)\n";
                    break;
                case "+":
                    if(acumuladorNumerico.length()!=0) {
                        saida += "('" + acumuladorNumerico + "', INT_LIT,2)\n";
                        acumuladorNumerico = "";
                    }
                    if(acumuladorIdent.length()!=0) {
                        saida += "('" + acumuladorIdent + "', IDENT, 1)\n";
                        acumuladorIdent = "";
                    }
                    saida+="('+', ADD_OP, 5)\n";
                    break;
                case ")":
                    if(acumuladorNumerico.length()!=0) {
                        saida += "('" + acumuladorNumerico + "', INT_LIT,2)\n";
                        acumuladorNumerico = "";
                    }
                    if(acumuladorIdent.length()!=0) {
                        saida += "('" + acumuladorIdent + "', IDENT, 1)\n";
                        acumuladorIdent = "";
                    }
                    saida+="(')', RPAREN, 4)\n";
                    break;
                case "(":
                    if(acumuladorNumerico.length()!=0) {
                        saida += "('" + acumuladorNumerico + "', INT_LIT,2)\n";
                        acumuladorNumerico = "";
                    }
                    if(acumuladorIdent.length()!=0) {
                        saida += "('" + acumuladorIdent + "', IDENT, 1)\n";
                        acumuladorIdent = "";
                    }
                    saida+="('(', LPAREN, 3)\n";
                    break;

            }


            //System.out.println(a);
        }
        System.out.println(entrada);
        System.out.println(saida);
    }
}


//        String entrada = "a := (aux - 2) * 200 / 19";

//        Token 	id	Comentário
//        IDENT 	1	Nomes de variáveis
//        INT_LIT	2	Números inteiros
//        LPAREN	3	'('
//        RPAREN	4	')'
//        ADD_OP	5	'+'
//        SUB_OP	6	'-'
//        MUL_OP	7	'*'
//        DIV_OP	8	'/'
//        GT_OP	9	'>'
//        LT_OP	10	'<'
//        EQ_OP	11	'=='
//        ASSIGN_OP	12	':='

