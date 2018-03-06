package carreraHipodromo;


class Hilo extends Thread {

	public int tiempoDescansado;
        
	public Hilo(String str) {
            super(str);
	}
        
    public void descansar() throws InterruptedException{
        sleep((long)(Math.random() * 1000));
    }

        @Override
	public void run() {
            for (int i=0; i<20; i++){
                try{
                    descansar();
                    tiempoDescansado = (int) (tiempoDescansado+(long) (Math.random()*5-1));
                    System.out.println(getName() + " se para, y a reccorrido: " + tiempoDescansado + " metros");
        	
                } catch(InterruptedException e){}
                if(tiempoDescansado >= 20 && getName().equalsIgnoreCase("Imperioso")){         
                    System.out.println("-- Imperioso ha ganado --");
                    System.out.println("\n");
                }

                else if(tiempoDescansado >= 20 && getName().equalsIgnoreCase("Pegaso")){
                    System.out.println("-- Pegaso ha ganado --");
                    System.out.println("\n");
                }
                else if(tiempoDescansado >= 20 && getName().equalsIgnoreCase("Perdigon")){
                    System.out.println("-- Perdigon ha ganado --");
                    System.out.println("\n");
                }
                else if(tiempoDescansado >= 20 && getName().equalsIgnoreCase("Babieca")){
                    System.out.println("-- Babieca ha ganado --");
                    System.out.println("\n");
                }
            }

            
        }
	
	public int getTiempoDormido(){
            return tiempoDescansado;
	}
	
}