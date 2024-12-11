
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFileChooser;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Lujain
 */
public class FrameMultiClassify extends javax.swing.JFrame {
    
    private Scanner scanner;  
  public double learningRate,Threshold,ydesaired,Yactual,error,delta,epoch;
  public double MSEE;
  int numNu;
  double weighted_sum[];
  double[] ya_outputs_temp;
  private JFileChooser fileChooser = new JFileChooser();

  double[]errore;
  double[]gradianterrore;
  ArrayList<String> fruit;
    ArrayList<Double> AOB = new ArrayList<>();
   double[] correction_weight;
   double[] correction_weighthidden;
   double[]correction_P;
   double[]newhidden_P;
   double[]oldhidden_P;
    double[]newoutput_P;
   double[]oldoutput_P;
  double[] correction_P_hidden;
  double max_iteration;
  int epochcounter=1;
  int maxindex=0;
  double MSEvalue=0;
  double maxOutput;
  double squaredDifference;
  double x1,x2,x3;
  int k=0;
   double acc;
 double E=0;
  
  
  double col;
  Map<String, Integer> colorIndexMap = new HashMap<>();
  Map<String, Integer> FruitIndexMap = new HashMap<>();
  double Numapp;
  double Numorang;
  double Numbannana;
   


 
  public ArrayList<String> colorList;
 
  
   
   public ArrayList<Double> Sweetness;
  

    public ArrayList<String> Colour;
     public ArrayList<String> yd;
 
      private ArrayList<Double>ColourDouble;
      private ArrayList<Double>ydDouble;
      private ArrayList<Double>yaDouble;
      
      
    private double[] w1_old, w2_old, w3_old, w4_old,w5_old, w1_new, w2_new, w3_new, w4_new,w5_new, errors, outputhidden,ya_outputs,value;
   private double ColourDoubleMin,ColourDoubleMax,SweetnessMin,SweetnessMax;
     String selectedactivateoutput;
     String selectedactivatehidden;
     public double[][] myArray;
     int counter_epoch;
     public boolean f;
     public int counter_error;     
     public double index;
     int iteration;
     double norsw,norcol;
     int correct=0;
     int all=0;
     
     
     
     
     
  

    /**
     * Creates new form FrameMultiClassify
     */
    public FrameMultiClassify() {
        this.scanner = new Scanner(System.in);  

        
        max_iteration=0;
       fruit= new ArrayList<String>();
       counter_error=0;
       iteration=0;
       index=0;
        ColourDouble = new ArrayList<Double>();
        ydDouble = new ArrayList<Double>();
         yaDouble=new ArrayList<Double>();
        AOB=new ArrayList<Double>();
        
        initComponents();
         ColourDoubleMin = 1000;
        SweetnessMin = 1000;
        SweetnessMax = -1000;
        ColourDoubleMax = -1000;
     
        Numapp=Numbannana=Numorang=0;
       
           
        
   activatehidden.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedactivatehidden = (String) activatehidden.getSelectedItem();
        }
    });

  
       colorList =new ArrayList<String>();
         Sweetness =new ArrayList<Double>();
   Colour =new ArrayList<String>();
      yd =new ArrayList<String>();
       
      
colorList.add("Green");  // Index 0
colorList.add("Red");   // Index 1
colorList.add("Greenorange");     // Index 2
colorList.add("Orange");  // Index 3
colorList.add("GreenYellow");     // Index 4
colorList.add("Yellow");  // Index 5

 fruit.add("Apple");//index0
 fruit.add("Orange");//index1
 fruit.add("Banana");//index2
         




    }
    public void initializeFromUI() {
    numNu = Integer.parseInt(num.getText());
    w1_old = new double[numNu];
    w2_old = new double[numNu];
    w3_old = new double[numNu];
    w4_old = new double[numNu];
    w5_old = new double[numNu];
     w1_new = new double[numNu];
    w2_new = new double[numNu];
    w3_new = new double[numNu];
    w4_new = new double[numNu];
    w5_new = new double[numNu];
     newoutput_P=new double[3];
   oldoutput_P=new double[3];
     newhidden_P=new double[numNu];
   oldhidden_P=new double[numNu];
   correction_P_hidden=new double[numNu];
   col = -1;
  
   
    
    
      weighted_sum = new double[numNu];
         outputhidden=new double[numNu];
         ya_outputs_temp = new double[3];
         ya_outputs = new double[3];
         value=new double[3];
         errore=new double[3];
         gradianterrore=new double[3];
        correction_weight = new double[3 * numNu];
        correction_P=new double[3];
        correction_weighthidden=new double[numNu*2+numNu];

}


               
   
     
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        activatehidden = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        num = new javax.swing.JTextField();
        maxepoch = new javax.swing.JTextField();
        learnrate = new javax.swing.JTextField();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(51, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("Linear multi-class  classifier");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Number of Neurons in hidden layer :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setText(" Learning Rate:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setText("Maximum Number of Epoch:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setText("Activation Function  for hidden layer:");

        activatehidden.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        activatehidden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "sigmoid", "Tanh", "Relu" }));

        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton2.setText("Learn");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton4.setText("upload file of data");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(151, 151, 151))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(learnrate, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(num)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(activatehidden, 0, 107, Short.MAX_VALUE)
                                    .addComponent(maxepoch))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton4)
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(learnrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maxepoch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activatehidden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        learningRate = Double.parseDouble(learnrate.getText());
        epoch = Integer.parseInt(maxepoch.getText());
       
        numNu = Integer.parseInt(num.getText());
        
       activatehidden.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedactivatehidden = (String) activatehidden.getSelectedItem();
        }
    });

    

         System.out.println("learningRate"+learningRate);
          System.out.println("Maxepoch"+epoch);
            System.out.println("num of nural in hidden"+numNu);
             System.out.println("activatehidden"+selectedactivatehidden);
              
              
        for (int j = 0; j < colorList.size(); j++) {
            colorIndexMap.put(colorList.get(j).toLowerCase(), j);
        }

        for (int i = 0; i < Colour.size(); i++) {
            String color = Colour.get(i).toLowerCase(); 
            Integer index = colorIndexMap.get(color);
            
            if (index != null) {
                ColourDouble.add(index.doubleValue());
                
            }
        }
        
        System.out.println();
    
            
        
        
         
                for (int j = 0; j <fruit.size(); j++) {
            FruitIndexMap.put(fruit.get(j).toLowerCase(), j);
           
            
        }
                
                
      for(int i=0;i<yd.size();i++){
            String currentString = yd.get(i).toLowerCase(); 
             Integer index = FruitIndexMap.get(currentString);
             if (index != null) {
                 
                ydDouble.add(index.doubleValue()+1);
                
            }
                    
                }

                    
     System.out.println();  
     max_iteration=yd.size();
        System.err.println("max iteration "+max_iteration);

 initializeFromUI();
     initialization();
       readFileAndProcess();

        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        Threshold=0;
        learningRate=0;
        error=0;
        epoch=0;
        
        
         learnrate.setText(null);
        maxepoch.setText(null);
       
      num.setText(null);
      activatehidden.setSelectedItem(null);
      
    
      
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed


          JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        try {
            Scanner fileReader = new Scanner(selectedFile);

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
               String[] tokenized = line.split("\\s+"); // Split by one or more whitespaces

if (tokenized.length >= 3) {
    Sweetness.add(Double.parseDouble(tokenized[0]));

    Colour.add(tokenized[1]);
    yd.add(tokenized[2]);
} else {
    System.err.println("Invalid line: " + line + ". Skipping.");
}
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        System.out.println("Data loaded from file: Sweetness=" + Sweetness + ", Colour=" + Colour + ", yd=" + yd);
    } else {
        System.out.println("File selection canceled.");
    }

  
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numActionPerformed
public void activationhidden(double nsw,double ncol, String Type) {
    
   
    for (int i = 0; i < numNu; i++) {
        
        weighted_sum[i] = (nsw * w1_old[i]) + (ncol * w2_old[i]);
        
        if (Type.equalsIgnoreCase("sigmoid")) {
            outputhidden[i] = sigmoid(weighted_sum[i] - Threshold);
        } else if (Type.equalsIgnoreCase("Tanh")) {
            outputhidden[i] = tanh(weighted_sum[i] - Threshold);
        } else {
            outputhidden[i] = ReLU(weighted_sum[i] - Threshold);
        }

    }
}
public int weight_update() {
    for (int i = 0; i < numNu; i++) {
        w1_new[i] = w1_old[i] + correction_weighthidden[i];
        w2_new[i] = w2_old[i] + correction_weighthidden[i];
        w3_new[i] = w3_old[i] + correction_weight[i];
        w4_new[i] = w4_old[i] + correction_weight[i+1];
        w5_new[i] = w5_old[i] + correction_weight[i+2];
        newhidden_P[i] = oldhidden_P[i] + correction_P_hidden[i];
        

    }
  
                
    
    for (int i = 0; i < 3; i++) {
        newoutput_P[i] = oldoutput_P[i] + correction_P[i];
        
      
    }
    
      for (int i = 0; i < numNu; i++){
     w1_old[i]=w1_new[i];
       w2_old[i]=w2_new[i];
       w3_old[i]=w3_new[i];
        w4_old[i]=w4_new[i];
        w5_old[i]=w5_new[i];
        oldhidden_P[i]=newhidden_P[i];
    }
      
      for (int i = 0; i < 3; i++) {
          oldoutput_P[i]=newoutput_P[i];
      }
      
    
    
    
    
    return 1;  
}

private void readFileAndProcess(){
    iteration=0;
    for(int i=0;i<max_iteration;i++){
   
       processFileData(Sweetness.get(i), ColourDouble.get(i));
       
     iteration++;
    }
     
}



public void processFileData(double sweet, double colour) {


//    norsw=normSW(sweet);
  //  norcol=normcol(colour);
 norsw=sweet;
    norcol=colour;
   
     
    
//  System.err.println("---------activationhidden for iteration --------"+iteration);

        
         for (int i = 0; i <numNu; i++) {
        
        weighted_sum[i] = (norsw * w1_old[i]) + (norcol * w2_old[i]);
        
        if (selectedactivatehidden.equalsIgnoreCase("sigmoid")) {
            outputhidden[i] = sigmoid(weighted_sum[i] - oldhidden_P[i]);
        } else if (selectedactivatehidden.equalsIgnoreCase("Tanh")) {
            outputhidden[i] = tanh(weighted_sum[i] - oldhidden_P[i]);
        } else {
            outputhidden[i] = ReLU(weighted_sum[i] - oldhidden_P[i]);
        }

    }
         

       
       // System.err.println("---------activationoutput for iteration --------"+iteration);
       
       
         for (int i = 0; i < numNu; i++) {
       
        ya_outputs_temp[0] += outputhidden[i] * w3_old[i];

    }
       ya_outputs_temp[0]-=oldoutput_P[0];
        
        
//        if (selectedactivateoutput.equalsIgnoreCase("sigmoid")) {
//            ya_outputs[0] = sigmoid(ya_outputs_temp[0] - oldoutput_P[0]);
//        } else if (selectedactivateoutput.equalsIgnoreCase("Tanh")) {
//           ya_outputs[0] = tanh(ya_outputs_temp[0] - oldoutput_P[0]);
//        } 
//        else {
//           ya_outputs[0] = ReLU(ya_outputs_temp[0]- oldoutput_P[0]);
//      }
    

    for (int i = 0; i < numNu; i++) {
        ya_outputs_temp[1] += outputhidden[i] * w4_old[i];

    }
    
ya_outputs_temp[1]-=oldoutput_P[1];
//        if (selectedactivateoutput.equalsIgnoreCase("sigmoid")) {
//            ya_outputs[1] = sigmoid(ya_outputs_temp[1] - oldoutput_P[1]);
//        } else if (selectedactivateoutput.equalsIgnoreCase("Tanh")) {
//            ya_outputs[1] = tanh(ya_outputs_temp[1] - oldoutput_P[1]);
//        } else {
//            ya_outputs[1] = ReLU(ya_outputs_temp[1] - oldoutput_P[1]);
//        }
    

    for (int i = 0; i < numNu; i++) {
        ya_outputs_temp[2] += outputhidden[i] * w5_old[i];

    }
ya_outputs_temp[2]-=oldoutput_P[2];
    
//        if (selectedactivateoutput.equalsIgnoreCase("sigmoid")) {
//            ya_outputs[2] = sigmoid(ya_outputs_temp[2] - oldoutput_P[2]);
//        } else if (selectedactivateoutput.equalsIgnoreCase("Tanh")) {
//            ya_outputs[2] = tanh(ya_outputs_temp[2] - oldoutput_P[2]);
//        } else {
//            ya_outputs[2] = ReLU(ya_outputs_temp[2] - oldoutput_P[2]);
//        }
        
        
        
     ya_outputs =softmax(ya_outputs_temp);
        
            
   
        // System.err.println("--------- weight_trainingoutput for iteration --------"+iteration);

    if (yd.get(iteration).equalsIgnoreCase("apple")){
    
                 
       errore[0]=1.0-ya_outputs[0];
       errore[1] =0 - ya_outputs[1];
       errore[2] =0 - ya_outputs[2];
       
       }
    
     if (yd.get(iteration).equalsIgnoreCase("orange")){
      
                 
       errore[0]=0-ya_outputs[0];
       errore[1] =1.0 - ya_outputs[1];
       errore[2] =0 - ya_outputs[2];
       
       }
     
      if (yd.get(iteration).equalsIgnoreCase("Banana")){
      
       errore[0]=0-ya_outputs[0];
       errore[1] =0 - ya_outputs[1];
       errore[2] =1.0 - ya_outputs[2];
       
       }
    
    
    
    
     
     double value[];

               
//if (selectedactivateoutput.equalsIgnoreCase("sigmoid")) {
//    value = drivativesigmoid(ya_outputs[0]);
//       
//}
//    else if (selectedactivateoutput.equalsIgnoreCase("Tanh")){
//          value=derivativeTanh(ya_outputs[0]);
//      }
//      else{
//        
//          value=derivativeReLU(ya_outputs[0]);
//      }

  value  =softmaxDerv(ya_outputs);
     
      gradianterrore[0]=errore[0]*value[0];
      

      
   
      
      
 
      
     
      
      
      
//if (selectedactivateoutput.equalsIgnoreCase("sigmoid")){
//    value = drivativesigmoid(ya_outputs[1]);
//}
// else if (selectedactivateoutput.equalsIgnoreCase("Tanh")){
//     value=derivativeTanh(ya_outputs[1]);
//      }
//      else{
//          value=derivativeReLU(ya_outputs[1]);
//      }
      gradianterrore[1]=errore[1]*value[1];
      
    
      
      

    
      
      
      
      
      
//      
//if (selectedactivateoutput.equalsIgnoreCase("sigmoid")){
//    value = drivativesigmoid(ya_outputs[2]);
//}
// else if (selectedactivateoutput.equalsIgnoreCase("Tanh")){
//     value=derivativeTanh(ya_outputs[2]);
//      }
//      else{
//          value=derivativeReLU(ya_outputs[2]);
//      }
      gradianterrore[2]=errore[2]*value[2];
      
    





      
for (int j = 0; j < numNu; j++) {
    correction_weight[j] = learningRate * gradianterrore[0] * outputhidden[j];
    
    correction_weight[numNu + j] = learningRate * gradianterrore[1] * outputhidden[j];
    correction_weight[2 * numNu + j] = learningRate * gradianterrore[2] * outputhidden[j];
}


correction_P[0] = learningRate * gradianterrore[0] * -1;
correction_P[1] = learningRate * gradianterrore[1] * -1;
correction_P[2] = learningRate * gradianterrore[2] * -1;



     


     
      //  System.err.println("--------- weight_traininghidden for iteration --------"+iteration);

       double[] gradianthidden = new double[numNu];
       double[] errore = new double[numNu];
   
    int t=0;

     for (int j = 0; j < numNu; j++) {
        double sum = 0.0;
       
            sum = gradianterrore[0] * w3_old[j] + gradianterrore[1] * w4_old[j] + gradianterrore[2] * w5_old[j];
        

        double value1;
         
        if (selectedactivatehidden.equalsIgnoreCase("sigmoid")) {
            value1 = drivativesigmoid(outputhidden[j]);
        } else if (selectedactivatehidden.equalsIgnoreCase("Tanh")){
            value1 = derivativeTanh(outputhidden[j]);
        } else {
            value1 = derivativeReLU(outputhidden[j]);
        }
        gradianthidden[j]=value1*sum;
        
correction_weighthidden[t] = gradianthidden[j] * learningRate *norsw ;
correction_weighthidden[t+1] = gradianthidden[j] * learningRate *norcol;
t+=2;
correction_P_hidden[j] = gradianthidden[j] * learningRate * -1;
     }
     
 

  
    //   System.err.println("--------- weight_update for iteration --------"+iteration);
    
    
int y=0;
int l=0;

        
      for (int i = 0; i < numNu; i++) {
        w1_new[i] = w1_old[i] + correction_weighthidden[y];
        w2_new[i] = w2_old[i] + correction_weighthidden[y+1];
   
      y+=2;
        w3_new[i] = w3_old[i] + correction_weight[l];
        w4_new[i] = w4_old[i] + correction_weight[l+numNu ];
        w5_new[i] = w5_old[i] + correction_weight[l+ 2*numNu];
      l++;
        
        newhidden_P[i] = oldhidden_P[i] + correction_P_hidden[i];
 
    }
  
                
    
    for (int i = 0; i < 3; i++) {
        newoutput_P[i] = oldoutput_P[i] + correction_P[i];
        
        
    }
    
      for (int i = 0; i < numNu; i++){
     w1_old[i]=w1_new[i];
       w2_old[i]=w2_new[i];
       w3_old[i]=w3_new[i];
        w4_old[i]=w4_new[i];
        w5_old[i]=w5_new[i];
        oldhidden_P[i]=newhidden_P[i];
    }
      
      for (int i = 0; i < 3; i++) {
          oldoutput_P[i]=newoutput_P[i];
      }
      
    //System.err.println("--------- end of iteration --------"+iteration);

  
  
  
//         for(int i=0;i<3;i++)
//       ya_outputs[i] =deNormalize(ya_outputs[i]);
           
           
 maxOutput = Double.MIN_VALUE;

for (int i = 0; i < ya_outputs.length; i++) {
    
    if (ya_outputs[i] > maxOutput) {
        maxOutput = ya_outputs[i];
        maxindex=i;
    }
  
}

for (int i = 0; i < ya_outputs.length; i++) {
    AOB.add(ya_outputs[i]);
}

//System.err.println("Max value in ya_outputs for iteration " + iteration + ": " + maxOutput);




yaDouble.add(iteration, maxOutput);


if (maxindex == 0) {
    
    Numapp++;
    all++;
    System.err.println(String.format("These features in iteration[%d] are for apple fruit", iteration));
    
    
   if (yd.get(iteration).equalsIgnoreCase("apple")) {
        correct++;
        
   }
       
    
} else if (maxindex == 1) {
    Numorang++;
    all++;
    System.err.println(String.format("These features in iteration[%d] are for orange fruit", iteration));
    if (yd.get(iteration).equalsIgnoreCase("orange")) {
 
        correct++;
   }
    
} else {
    Numbannana++;
    all++;
    
    System.err.println(String.format("These features in iteration[%d] are for banana fruit", iteration));
    if (yd.get(iteration).equalsIgnoreCase("banana")) {
        correct++;
        
   }
}




if ((iteration+1 == max_iteration)){
     
  k=0;
  


    for (int i = 0; i < max_iteration; i++) {
      

      if (yd.get(i).equalsIgnoreCase("apple")) {
           x1=1.0;
           x2=0.0;
           x3=0.0;
           
           }
       if (!(yd.get(i).equalsIgnoreCase("apple"))) {
                x1=0.0;
            }
      if (yd.get(i).equalsIgnoreCase("orange")) {
          x2=1.0;
          x1=0.0;
          x3=0.0;
          }
      
       if (!(yd.get(i).equalsIgnoreCase("orange"))) {
                x2=0.0;
            }
       
      if (yd.get(i).equalsIgnoreCase("banana")) {
    x3=1.0;
    x1=0.0;
    x2=0.0;
   }
       if (!(yd.get(i).equalsIgnoreCase("banana"))) {
                x3=0.0;
            }
      
     squaredDifference = Math.pow(x1 - AOB.get(k), 2)+Math.pow(x2 - AOB.get(k+1), 2)+Math.pow(x3 - AOB.get(k+2), 2);
     k=k+3;
        MSEvalue += squaredDifference;
    }
    

    MSEvalue /= max_iteration;

    System.err.println("MSE for Epoch " + epochcounter + ": " + MSEvalue);

     
    MSEvalue=0.0;
     
    
    
      iteration = 0;
      
      
     if ((double) epochcounter == epoch) {
         double v=max_iteration*epoch;
         double c=((double)correct/v)*100;
         System.err.println("corectness value"+c+"%");
        
         
           System.err.println("check ? T /F:");
        String check = scanner.next();

        while ("T".equalsIgnoreCase(check)) {  
            System.err.println("Enter sweetness:");
            double sw = scanner.nextDouble();
            System.err.println("Enter color:");
            String colu = scanner.next();

            String color = colu.toLowerCase();
            Integer index = colorIndexMap.get(color);

            processFileData(sw, index);

            System.err.println("check ? T /F:");
            check = scanner.next();
        }
        
        
}
    else{
         AOB.clear();

          epochcounter++;
         
    readFileAndProcess();
    

    }
}


}
        
        
   public void weight_trainingoutput(String Type){
       
     
         
    
     errore[0]=ydDouble.get(iteration)-ya_outputs[0];
     
     
      double value;

               
if (Type.equalsIgnoreCase("sigmoid")) {
    value = drivativesigmoid(ya_outputs[0]);
}
    else if (Type.equalsIgnoreCase("Tanh")){
          value=derivativeTanh(ya_outputs[0]);
      }
      else{
        
          value=derivativeReLU(ya_outputs[0]);
      }
     
      gradianterrore[0]=errore[0]*value;
      
System.out.println("Errore [0]: " + errore[0]);
System.out.println("Gradient Errore[0]: " + gradianterrore[0]);
      
   
      
      
  
  
       
      errore[1] =ydDouble.get(iteration) - ya_outputs[1];
      
      
      
if (Type.equalsIgnoreCase("sigmoid")){
    value = drivativesigmoid(ya_outputs[1]);
}
 else if (Type.equalsIgnoreCase("Tanh")){
     value=derivativeTanh(ya_outputs[1]);
      }
      else{
          value=derivativeReLU(ya_outputs[1]);
      }
      gradianterrore[1]=errore[1]*value;
      
      System.out.println("Errore [1]: " + errore[1]);
System.out.println("Gradient Errore[1]: " + gradianterrore[1]);
      
      
      
      
      
      
    
      
      

      errore[2] =ydDouble.get(iteration) - ya_outputs[2];
      
      
      
      
      
      
if (Type.equalsIgnoreCase("sigmoid")){
    value = drivativesigmoid(ya_outputs[2]);
}
 else if (Type.equalsIgnoreCase("Tanh")){
     value=derivativeTanh(ya_outputs[2]);
      }
      else{
          value=derivativeReLU(ya_outputs[2]);
      }
      gradianterrore[2]=errore[2]*value;
      
      System.out.println("Errore [2]: " + errore[2]);
System.out.println("Gradient Errore[2]: " + gradianterrore[2]);
      





      
for (int j = 0; j < numNu; j++) {
    correction_weight[j] = learningRate * gradianterrore[0] * outputhidden[j];
    
    correction_weight[numNu + j] = learningRate * gradianterrore[1] * outputhidden[j];
    correction_weight[2 * numNu + j] = learningRate * gradianterrore[2] * outputhidden[j];
}


correction_P[0] = learningRate * gradianterrore[0] * -1;
correction_P[1] = learningRate * gradianterrore[1] * -1;
correction_P[2] = learningRate * gradianterrore[2] * -1;

for (int k = 0; k < correction_P.length; k++) {
    System.out.println("correction_P_Output[" + k + "]: " + correction_P[k]);
}

     
       
      
       
      
      
      
      
               

   }
   
   
   public void weight_traininghidden(double sw,double col,String Type){

       double[] gradianthidden = new double[numNu];
       double[] errore = new double[numNu];
  
   

     for (int j = 0; j < numNu; j++) {
        double sum = 0.0;
    
            sum = gradianterrore[0] * w3_old[j] + gradianterrore[1] * w4_old[j] + gradianterrore[2] * w5_old[j];
               System.out.println("sum[" + j + "]: " + sum);
        

        double value;
         
        if (Type.equalsIgnoreCase("sigmoid")) {
            value = drivativesigmoid(outputhidden[j]);
        } else if (Type.equalsIgnoreCase("Tanh")){
            value = derivativeTanh(outputhidden[j]);
        } else {
            value = derivativeReLU(outputhidden[j]);
        }
        gradianthidden[j]=value*sum;
        
    correction_weighthidden[j] = gradianthidden[j] * learningRate *sw ;
correction_weighthidden[j+1] = gradianthidden[j] * learningRate *col;
correction_P_hidden[j] = gradianthidden[j] * learningRate * -1;


System.out.println("gradianthidden[" + j + "]: " + gradianthidden[j]);
System.out.println("correction_weighthidden[" + j + "]: " + correction_weighthidden[j]);
System.out.println("correction_weighthidden[" + (j + 1) + "]: " + correction_weighthidden[j + 1]);
System.out.println("correction_P_hidden[" + (j) + "]: " + correction_P_hidden[j ]);

      
   }
   }
public void activationoutput(String type) {
    
    
        System.err.println("---------activationoutput for iteration --------"+iteration);

    for (int i = 0; i < numNu; i++) {
       
        ya_outputs_temp[0] += outputhidden[i] * w3_old[i];
    }
        
        if (type.equalsIgnoreCase("sigmoid")) {
            ya_outputs[0] = sigmoid(ya_outputs_temp[0] - Threshold);
        } else if (type.equalsIgnoreCase("Tanh")) {
           ya_outputs[0] = tanh(ya_outputs_temp[0] - Threshold);
        } else {
            ya_outputs[0] = ReLU(ya_outputs_temp[0] - Threshold);
        }
    

    for (int i = 0; i < numNu; i++) {
        ya_outputs_temp[1] += outputhidden[i] * w4_old[i];
    }
        if (type.equalsIgnoreCase("sigmoid")) {
            ya_outputs[1] = sigmoid(ya_outputs_temp[1] - Threshold);
        } else if (type.equalsIgnoreCase("Tanh")) {
            ya_outputs[1] = tanh(ya_outputs_temp[1] - Threshold);
        } else {
            ya_outputs[1] = ReLU(ya_outputs_temp[1] - Threshold);
        }
    

    for (int i = 0; i < numNu; i++) {
        ya_outputs_temp[2] += outputhidden[i] * w5_old[i];
    }
        if (type.equalsIgnoreCase("sigmoid")) {
            ya_outputs[2] = sigmoid(ya_outputs_temp[2] - Threshold);
        } else if (type.equalsIgnoreCase("Tanh")) {
            ya_outputs[2] = tanh(ya_outputs_temp[2] - Threshold);
        } else {
            ya_outputs[2] = ReLU(ya_outputs_temp[2] - Threshold);
        }
        for (int i = 0; i < ya_outputs.length; i++) {
    System.out.println("ya_output{" + i + "}: " + ya_outputs[i]);
}
        
    
   
   

}
 public double normSW(double in) {
    double IMin = 1;
    double IMax = 10;
    double NMax = 1;
    double NMin = -1;

    double I = ((in - IMin) * ((NMax - NMin) / (IMax - IMin)) + NMin);
    

    
    return I;
}
  
public double normcol(double in) {
    double IMin = 0;
    double IMax = 5;
    double NMax = 1;
    double NMin = -1;

    double I = ((in - IMin) * ((NMax - NMin) / (IMax - IMin)) + NMin);
    

    
    return I;
}
 public double deNormalize (double in ){
    double Nmin , Omax , Omin , Nmax , O ;
    double On;
    On = in; 
    Omin = 1;
    Omax = 3;
    Nmax = 1 ; 
    Nmin =-1 ;
    
    
    O =  ((On - Nmin )*((Omax - Omin)/(Nmax-Nmin)) + Omin);
    
    
    return O;
  
    }  
 
 


     
public static double getRandomNumber(double d) {

        Random random = new Random();

        double randomNumber = -d + (d - (-d)) * random.nextDouble();

        return randomNumber;
    }
  
      public void initialization(){
        
          
          
      
     Threshold= getRandomNumber(1.2);
 
   
      
      
      for (int i = 0; i < numNu; i++) {
       w1_old[i] =getRandomNumber(1.2) ;
        w2_old[i] = getRandomNumber(1.2);
         oldhidden_P[i]=getRandomNumber(1.2);
        
      }
      
      double d = 2.4 / (double) numNu;
      
      
       for (int i = 0; i < numNu; i++) {
           
         w3_old[i] = getRandomNumber(d);
        w4_old[i] = getRandomNumber(d);
        w5_old[i] = getRandomNumber(d);
       }
      
       
         for(int i=0;i<3;i++)
        oldoutput_P[i]=getRandomNumber(d);
         
         
      }
public double sigmoid(double x) {
    return (1 / (1 + Math.exp(-x)));
}

public double drivativesigmoid(double x) {
    double v=x* (1.0 - x);
    return  v;
}
public double tanh(double x) {
    
     return ((2 / (1 + Math.exp(-2 * x))) - 1);
}

public double derivativeTanh(double x) {
   
    return (1-(Math.pow( x, 2)));
}

public double ReLU(double x) {
    return (x < 0) ? 0 : x;
}
public double derivativeReLU(double x) {
    return (x < 0) ? 0 : 1;
}
public double[]softmax(double []outNe){
    double []result=new double[3];
    double sum=0.0;
    for(int i=0;i<outNe.length;i++){
        result[i]=Math.exp(outNe[i]);
        sum+=result[i];
    }
    for(int i=0;i<outNe.length;i++){
        outNe[i]=result[i]/sum;
    }
    return outNe;
    
}
public static double[]softmaxDerv(double[] out){
    double[] drev=new double[out.length];
    for(int i=0;i<out.length;i++){
        drev[i]=out[i]*(1-out[i]);
    }
    return drev;
}


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMultiClassify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMultiClassify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMultiClassify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMultiClassify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMultiClassify().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> activatehidden;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField learnrate;
    private javax.swing.JTextField maxepoch;
    private javax.swing.JTextField num;
    // End of variables declaration//GEN-END:variables
}
