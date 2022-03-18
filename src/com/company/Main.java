package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String saida = "";
        String entrada = "a := (aux == 2) * 200 / 19";
        entrada = entrada.replace(" ","");

        String[] tst = entrada.split("");

        String aux="";
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



            switch (a) {
                case ":=":
                    saida+="(':=', ASSIGN_OP, 12)\n";
                    aux="";
                    break;
                case "==":
                    saida+="('==', EQ_OP, 11)\n";
                    break;
                case "<":
                    saida+="('<', LT_OP, 10)\n";
                    break;
                case "/":
                    saida+="('/', DIV_OP, 8)\n";
                    break;
                case "*":
                    saida+="('*', MUL_OP, 7)\n";
                    break;
                case "-":
                    saida+="('-', SUB_OP, 6)\n";
                    break;
                case "+":
                    saida+="('+', ADD_OP, 5)\n";
                    break;
                case ")":
                    saida+="(')', RPAREN, 4)\n";
                    break;
                case "(":
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
