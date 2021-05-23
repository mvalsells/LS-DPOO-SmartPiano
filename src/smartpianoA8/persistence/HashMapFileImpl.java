package smartpianoA8.persistence;

import smartpianoA8.presentation.views.customComponents.JPPiano;
import smartpianoA8.presentation.views.customComponents.Tecla;

import java.awt.event.KeyEvent;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HashMapFileImpl implements HashMapFile{
    public HashMapFileImpl(){

    }

    @Override
    public HashMap<Integer, Tecla> read(String username){
        String ruta = "resources/hmFiles/"+username+".txt";
        HashMap<Integer, Tecla> hmTecles = new HashMap<>();
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            if(br.readLine().equals("key,nota")){
                String line;
                while ((line=br.readLine())!=null){
                    String[] split = line.split(",");
                    hmTecles.put(Integer.valueOf(split[0]), new Tecla(Integer.valueOf(split[1])));
                }
            }
        } catch (FileNotFoundException e) {
            HashMap<Integer,Tecla> hmTeclas = new HashMap<>();
            int valorMusical = 48;
            int codeTecla = KeyEvent.VK_A;

            for(int i = 0; i< JPPiano.OCTAVES; i++){

                for(int j=0; j<12;j++){

                    hmTeclas.put(codeTecla,new Tecla(valorMusical));
                    valorMusical++;
                    codeTecla++;
                    if(codeTecla==KeyEvent.VK_Z+1){
                        codeTecla = KeyEvent.VK_0;
                    }
                }
            }
            write(hmTeclas,username);
            read(username);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  hmTecles;
    }

    @Override
    public void write(HashMap<Integer, Tecla> hmTeclas, String username){
        String ruta = "resources/hmFiles/"+username+".txt";
        try {
            StringBuilder textToWrite = new StringBuilder();
            textToWrite.append("key,nota\n");
            FileWriter fw = new FileWriter(ruta,false);
            for (Map.Entry<Integer, Tecla> en: hmTeclas.entrySet()){
                textToWrite.append(en.getKey());
                textToWrite.append(",");
                textToWrite.append(en.getValue().getNota());
                textToWrite.append("\n");
            }
            fw.write(textToWrite.toString());
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
