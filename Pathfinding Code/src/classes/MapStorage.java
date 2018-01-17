package classes;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EpicJ
 */
import java.awt.geom.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
public class MapStorage {
    
    List<Line2D.Double> obsList;
    List<Point2D.Double> destList;
    BufferedReader br;
    double point1X, point1Y, point2X, point2Y;
    
    public MapStorage(){
        
        
        obsList = new ArrayList<Line2D.Double>();
        destList = new ArrayList<Point2D.Double>();
        try{
          FileReader filereader = new FileReader("testFile");
          br = new BufferedReader(filereader);
          String line = br.readLine();
          while(line != null){
              point1X = Double.parseDouble(line);
              line = br.readLine();              
              point1Y = Double.parseDouble(line);
              line = br.readLine(); 
              point2X = Double.parseDouble(line);
              line = br.readLine();   
              point2Y = Double.parseDouble(line);
              br.readLine();
              line = br.readLine(); 
              
              obsList.add(new Line2D.Double(new Point2D.Double(point1X,point1Y),new Point2D.Double(point2X,point2Y)));
          }
        }
        catch(FileNotFoundException e){
            System.out.println("Wrong filename or missing file.");
            
        }
        catch(IOException ex){
            System.out.println("AHHHHHHHHHH something went wrong");
            
        }
        try{
          FileReader filereader = new FileReader("testDestFile");
          br = new BufferedReader(filereader);
          String line = br.readLine();
          while(line != null){
              point1X = Double.parseDouble(line);
              line = br.readLine();              
              point1Y = Double.parseDouble(line);
              
              br.readLine();
              line = br.readLine(); 
              
              obsList.add(new Line2D.Double(new Point2D.Double(point1X,point1Y),new Point2D.Double(point2X,point2Y)));
          }
        }
        catch(FileNotFoundException e){
            System.out.println("Wrong filename or missing file.");
            
        }
        catch(IOException ex){
            System.out.println("AHHHHHHHHHH something went wrong");
            
        }
        
        
    }
    
    
}
