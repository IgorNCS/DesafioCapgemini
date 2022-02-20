package capgemini;

import java.util.Scanner;//UTILIZAR SCANER
import java.util.Arrays;//UTILIZAR ARRAYS

class Exercicios{
    Scanner leitor = new Scanner(System.in);//INICIALIZA SCANER PARA VALORES DIGITADOS
    public void questao1(){
        int spacebar,amount;      
        System.out.println("Digite a quantidade de * para a escada:");
        amount = leitor.nextInt();//PEGA VALOR DE ESTRELAS        
        for(int i=0;i<amount;i++){
            spacebar=amount-i;
            for(int j=0;j<=spacebar;j++){//FOR PARA CRIAR OS ESPAÇOS
                System.out.print(" ");
            }
            for(int k=0;k<=i;k++){//FOR PARA COLOCAR AS ESTRELAS
                if(k==i){
                    System.out.println("*");//PULAR LINHA SE FOR A ULTIMA ESTRELA DA LINHA   
                }else{
                    System.out.print("*");//APENAS COLOCAR ESTRELA   
                }    
            }   
        }
    }
    
    public void questao2(){
        String senha;
        System.out.println("Digite a senha:");
        senha = leitor.next();
        int senhaTamanho = senha.length();
        if(senhaTamanho<6)//VERIFICAÇÕES DA FORÇA DA SENHA
            System.out.println("Precisa de mais"+ (6-senhaTamanho) +" caracteres!");
        if(!verificarCaracteresEspeciais(senha))//PEGA O VALOR DA FUNCAO BOLEANA EM NEGAÇÃO PASSANDO A SENHA
            System.out.println("Precisa de um caracter especial!");   
        if(!verificarSenhaMaiuscula(senha))
            System.out.println("Precisa de um caracter Maiusculo!");
        if(!verificarSenhaMinuscula(senha))
            System.out.println("Precisa de um caracter Minusculo!");
        if(!verificarSenhaDigito(senha))
            System.out.println("Precisa de um caracter Numerico!");   
    }
    
    public boolean verificarCaracteresEspeciais(String senha){
        if (senha.contains("!")) //VERIFICAR SE NA STRING EXISTE-CONTEM O CARACTER
            return true;
        if (senha.contains("@"))
            return true;
        if (senha.contains("#"))
            return true;
        if (senha.contains("$"))
            return true;
        if (senha.contains("%"))
            return true;
        if (senha.contains("^"))
            return true;
        if (senha.contains("&"))
            return true;
        if (senha.contains("("))
            return true;
        if (senha.contains(")"))
            return true;
        if (senha.contains("-"))
            return true;
        if (senha.contains("+"))
            return true;
        
        return false;//CASO NÃO TENHA CARACTER ESPECIAL, PASSA POR TODOS OS IF E RETORNA FALSO
    }
    
    public boolean verificarSenhaMaiuscula(String senha){
        char[] caracteres = senha.toCharArray();//TRANSFORMA A STRING EM ARRAY DE CARACTER
        for(int i=0; i<senha.length();i++){ //PEGA O TAMANHO DA STRING
            if(Character.isUpperCase(caracteres[i]))//VERIFICA SE CARACTERER É MAIUSCULO
                return true;
        }
        return false;
    }
    
    public boolean verificarSenhaMinuscula(String senha){
        char[] caracteres = senha.toCharArray();
        for(int i=0; i<senha.length();i++){
            if(Character.isLowerCase(caracteres[i]))//VERIFICA SE CARACTER É MINUSCULO
                return true;
        }
        return false;
    }
    
    public boolean verificarSenhaDigito(String senha){
        char[] caracteres = senha.toCharArray();
        for(int i=0; i<senha.length();i++){
            if(Character.isDigit(caracteres[i]))//VERIFICA SE CARACTER É DIGITO-NUMERO
                return true;
        }
        return false;
    }
    
    
    public void questao3(){
        String anagrama,anagramaMini = null,anagramaMiniCheck = null;
        System.out.println("Escreva a palavra que deseja verificar a quantidade de Anagramas Pares:");
        anagrama = leitor.next();
        int contadorAnagramas=0;
        char[] anagArray = anagrama.toCharArray();//ANAGRAMA INICIALIZADO COMO ARRAY
        char[] anagArrayMini = null, anagArrayMiniCheck = null;//ARRAYS PARA VERIFICAR ANAGRAMA
        String anagIndex = null, anagIndexCheck = null;
        char[] anagArrayIndex =null, anagArrayIndexCheck=null;//VERIFICAR ONDE ESTÁ VERIFICANDO SE É ANAGRAMA EM ARRAY
        for(int i=0;i<anagrama.length();i++){ //INICIAR ANAGRAMA
            anagramaMini = String.valueOf(anagArray[i]);
            anagIndex = Integer.toString(i);
            
            //ESSE FOR DIZ O TAMANHO DO CONJUNTO DE CARACTERES
            for(int countSize=1;countSize<anagrama.length();countSize++){
                if(countSize+i<anagrama.length()){//NÃO PASSAR TAMANHO DO ANAGRAMA
                    for(int countAnagramaSize=1;countAnagramaSize<=countSize;countAnagramaSize++){
                        if(countAnagramaSize==1){//SE FOR O PRIMEIRO ATRIBUI E NÃO CONCATENA
                            anagramaMini = String.valueOf(anagArray[i]);
                            anagArrayMini = anagramaMini.toCharArray();
                            anagIndex=Integer.toString(i);                  
                        }else{
                            anagramaMini += String.valueOf(anagArray[countAnagramaSize-1]);  
                            anagArrayMini = anagramaMini.toCharArray();
                            anagIndex+=Integer.toString(countAnagramaSize-1);
                        }
                    }
                    for(int indexCheck=i+1;indexCheck<=anagrama.length();indexCheck++){
                        if(indexCheck+countSize<=anagrama.length()){
                        for(int countAnagramaCheckSize=indexCheck;countAnagramaCheckSize<indexCheck+countSize;countAnagramaCheckSize++){
                            if(countAnagramaCheckSize==indexCheck){//SE FOR O PRIMEIRO ATRIBUI E NÃO CONCATENA
                            anagramaMiniCheck = String.valueOf(anagArray[countAnagramaCheckSize]);
                            anagArrayMiniCheck = anagramaMiniCheck.toCharArray();
                            anagIndexCheck=Integer.toString(i);
                            }else{
                            anagramaMiniCheck += String.valueOf(anagArray[countAnagramaCheckSize]);  
                            anagArrayMiniCheck = anagramaMiniCheck.toCharArray();
                            anagIndexCheck += Integer.toString(countAnagramaCheckSize);
                            }
                        }
                        //PARTE DA VERIFICAÇÃO SE É IGUAL
                        anagArrayMiniCheck = anagramaMiniCheck.toCharArray();//COLOCAR EM ARRAY O VALOR EM STRING
                        
                        Arrays.sort(anagArrayMiniCheck);//ARRAYS.SORT COLOCA EM ORDEM ALFABETICA-MENOR PARA MAIOR
                        Arrays.sort(anagArrayMini);
                        Arrays.sort(anagArrayIndexCheck);
                        Arrays.sort(anagArrayIndex);
                        
                        anagArrayIndex=anagIndex.toCharArray();
                        anagArrayIndexCheck=anagIndexCheck.toCharArray();
                          
                        if(indexCheck!=i){
                            if(Arrays.equals(anagArrayMini, anagArrayMiniCheck)){
                                contadorAnagramas++;
                            }
                        }     
                        }
                    }
                }
            }       
        }
        System.out.println("A quantidade de Anagramas Pares é: "+contadorAnagramas);
    }
    
    public void division(){ //APENAS DIVIDIR A STRING 
        System.out.println("=========================");
    }
    
}

public class Capgemini {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean menuOpen=true;
        int menuChoice;
        Exercicios e = new Exercicios();
        
        do{
            System.out.println("Escolha a questão:");
            System.out.println("1 - Para questão da escada de *!");
            System.out.println("2 - Para questão de ajudar Debora com a senha!");
            System.out.println("3 - Para questão de pares de anagramas!");
            System.out.println("0 - Para Encerrar!");
            menuChoice = leitor.nextInt();
            System.out.println(menuChoice);
            switch(menuChoice){
                case 1: e.questao1();e.division();break;
                case 2:e.questao2();e.division();break;
                case 3:e.questao3();e.division();break;
                case 0:menuOpen=false;break;
            }
        }while(menuOpen);
        
        
      
    }
    
}
