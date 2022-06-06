/*     */ package principal;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JColorChooser;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.Timer;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MemDirectXTelaTst
/*     */   extends JDialog
/*     */ {
/*  36 */   private final JPanel contentPanel = new JPanel();
/*  37 */   final JButton[] btn = new JButton[40];
/*     */   
/*     */   JLabel lblTempo;
/*     */   JLabel lblPontuacao;
/*  41 */   String[] imagem_botao = new String[37];
/*  42 */   int btn_aberto = 0;
/*  43 */   static boolean errou = false;
/*  44 */   long millis = 400L;
/*  45 */   int ind = 0;
/*  46 */   int x = 10;
/*  47 */   int y = 11;
/*  48 */   int pontuacao = 0;
/*  49 */   int acertos = 0;
/*     */   
/*  51 */   static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
/*  52 */   int hor = 0;
/*  53 */   int min = 0;
/*  54 */   int seg = 0;
/*  55 */   String[] st = { "", "", "" };
/*     */   
/*     */   Timer timer;
/*  58 */   private static String caminho_ranking = System.getProperty("user.home") + "/ranking.txt";
/*     */   
/*     */ 
/*  61 */   private String caminho_imagens = "linguagens/";
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/*  65 */       MemDirectXTelaTst dialog = new MemDirectXTelaTst();
/*  66 */       dialog.setDefaultCloseOperation(2);
/*  67 */       dialog.setVisible(true);
/*     */     } catch (Exception e) {
/*  69 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public MemDirectXTelaTst() {
/*  74 */     setBounds(100, 100, 598, 540);
/*  75 */     getContentPane().setLayout(new BorderLayout());
/*  76 */     this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  77 */     getContentPane().add(this.contentPanel, "Center");
/*  78 */     this.contentPanel.setLayout(null);
/*     */     
/*  80 */     JButton button = new JButton("");
/*  81 */     button.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/10_E.PNG")));
/*  82 */     button.setBounds(10, 11, 70, 70);
/*  83 */     this.contentPanel.add(button);
/*     */     
/*  85 */     JButton button_1 = new JButton("");
/*  86 */     button_1.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/11_F.PNG")));
/*  87 */     button_1.setBounds(90, 11, 70, 70);
/*  88 */     this.contentPanel.add(button_1);
/*     */     
/*  90 */     JButton button_2 = new JButton("");
/*  91 */     button_2.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/13_G.PNG")));
/*  92 */     button_2.setBounds(170, 11, 70, 70);
/*  93 */     this.contentPanel.add(button_2);
/*     */     
/*  95 */     JButton button_3 = new JButton("");
/*  96 */     button_3.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/15_H.PNG")));
/*  97 */     button_3.setBounds(250, 11, 70, 70);
/*  98 */     this.contentPanel.add(button_3);
/*     */     
/* 100 */     JButton button_4 = new JButton("");
/* 101 */     button_4.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/17_I.PNG")));
/* 102 */     button_4.setBounds(330, 11, 70, 70);
/* 103 */     this.contentPanel.add(button_4);
/*     */     
/* 105 */     JButton button_5 = new JButton("");
/* 106 */     button_5.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/19_J.PNG")));
/* 107 */     button_5.setBounds(410, 11, 70, 70);
/* 108 */     this.contentPanel.add(button_5);
/*     */     
/* 110 */     JButton button_6 = new JButton("");
/* 111 */     button_6.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/1_A.PNG")));
/* 112 */     button_6.setBounds(490, 11, 70, 70);
/* 113 */     this.contentPanel.add(button_6);
/*     */     
/* 115 */     JButton button_7 = new JButton("");
/* 116 */     button_7.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/21_K.PNG")));
/* 117 */     button_7.setBounds(10, 86, 70, 70);
/* 118 */     this.contentPanel.add(button_7);
/*     */     
/* 120 */     JButton button_8 = new JButton("");
/* 121 */     button_8.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/23_L.PNG")));
/* 122 */     button_8.setBounds(90, 86, 70, 70);
/* 123 */     this.contentPanel.add(button_8);
/*     */     
/* 125 */     JButton button_9 = new JButton("");
/* 126 */     button_9.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/25_M.PNG")));
/* 127 */     button_9.setBounds(170, 86, 70, 70);
/* 128 */     this.contentPanel.add(button_9);
/*     */     
/* 130 */     JButton button_10 = new JButton("");
/* 131 */     button_10.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/27_N.PNG")));
/* 132 */     button_10.setBounds(250, 86, 70, 70);
/* 133 */     this.contentPanel.add(button_10);
/*     */     
/* 135 */     JButton button_11 = new JButton("");
/* 136 */     button_11.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/31_P.PNG")));
/* 137 */     button_11.setBounds(330, 86, 70, 70);
/* 138 */     this.contentPanel.add(button_11);
/*     */     
/* 140 */     JButton button_12 = new JButton("");
/* 141 */     button_12.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/35_R.PNG")));
/* 142 */     button_12.setBounds(410, 86, 70, 70);
/* 143 */     this.contentPanel.add(button_12);
/*     */     
/* 145 */     JButton button_13 = new JButton("");
/* 146 */     button_13.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/3_B.PNG")));
/* 147 */     button_13.setBounds(490, 86, 70, 70);
/* 148 */     this.contentPanel.add(button_13);
/*     */     
/* 150 */     JButton button_14 = new JButton("");
/* 151 */     button_14.setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource("/ImagensMem/linguagens/5_C.PNG")));
/* 152 */     button_14.setBounds(10, 167, 70, 70);
/* 153 */     this.contentPanel.add(button_14);
/*     */     
/* 155 */     JButton button_15 = new JButton("");
/* 156 */     button_15.setBounds(90, 167, 70, 70);
/* 157 */     this.contentPanel.add(button_15);
/*     */     
/* 159 */     JButton button_16 = new JButton("");
/* 160 */     button_16.setBounds(170, 167, 70, 70);
/* 161 */     this.contentPanel.add(button_16);
/*     */     
/* 163 */     JButton button_17 = new JButton("");
/* 164 */     button_17.setBounds(250, 167, 70, 70);
/* 165 */     this.contentPanel.add(button_17);
/*     */     
/* 167 */     setLocationRelativeTo(null);
/* 168 */     setModal(true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void reiniciar()
/*     */   {
/* 512 */     List<Integer> numeros = new ArrayList();
/* 513 */     for (int i = 1; i <= 36; i++) {
/* 514 */       numeros.add(Integer.valueOf(i));
/*     */     }
/*     */     
/* 517 */     Collections.shuffle(numeros);
/*     */     
/*     */ 
/* 520 */     String letra = "";
/* 521 */     int j = 1;
/* 522 */     for (int i = 0; i < 36; i++)
/*     */     {
/* 524 */       letra = buscarLetra(((Integer)numeros.get(i)).intValue());
/* 525 */       this.imagem_botao[j] = ("/ImagensMem/" + this.caminho_imagens + numeros.get(i) + "_" + letra + ".PNG");
/*     */       
/* 527 */       j++;
/*     */     }
/*     */     
/* 530 */     this.btn_aberto = 0;
/* 531 */     errou = false;
/* 532 */     this.ind = 0;
/* 533 */     this.x = 10;
/* 534 */     this.y = 11;
/* 535 */     this.pontuacao = 0;
/* 536 */     this.lblPontuacao.setText(Integer.toString(this.pontuacao));
/* 537 */     this.acertos = 0;
/* 538 */     this.hor = 0;
/* 539 */     this.min = 0;
/* 540 */     this.seg = 0;
/* 541 */     this.timer.restart();
/*     */   }
/*     */   
/*     */   public String buscarLetra(int num) {
/* 545 */     if (num != 0) {
/* 546 */       if ((num == 1) || (num == 2))
/* 547 */         return "A";
/* 548 */       if ((num == 3) || (num == 4))
/* 549 */         return "B";
/* 550 */       if ((num == 5) || (num == 6))
/* 551 */         return "C";
/* 552 */       if ((num == 7) || (num == 8))
/* 553 */         return "D";
/* 554 */       if ((num == 9) || (num == 10))
/* 555 */         return "E";
/* 556 */       if ((num == 11) || (num == 12))
/* 557 */         return "F";
/* 558 */       if ((num == 13) || (num == 14))
/* 559 */         return "G";
/* 560 */       if ((num == 15) || (num == 16))
/* 561 */         return "H";
/* 562 */       if ((num == 17) || (num == 18))
/* 563 */         return "I";
/* 564 */       if ((num == 19) || (num == 20))
/* 565 */         return "J";
/* 566 */       if ((num == 21) || (num == 22))
/* 567 */         return "K";
/* 568 */       if ((num == 23) || (num == 24))
/* 569 */         return "L";
/* 570 */       if ((num == 25) || (num == 26))
/* 571 */         return "M";
/* 572 */       if ((num == 27) || (num == 28))
/* 573 */         return "N";
/* 574 */       if ((num == 29) || (num == 30))
/* 575 */         return "O";
/* 576 */       if ((num == 31) || (num == 32))
/* 577 */         return "P";
/* 578 */       if ((num == 33) || (num == 34))
/* 579 */         return "Q";
/* 580 */       if ((num == 35) || (num == 36)) {
/* 581 */         return "R";
/*     */       }
/*     */     }
/* 584 */     return "";
/*     */   }
/*     */   
/*     */   public void botoes() {
/* 588 */     for (int i = 1; i <= 36; i++) {
/* 589 */       this.ind = i;
/* 590 */       this.btn[this.ind] = new JButton("");
/* 591 */       this.btn[this.ind].setBounds(this.x, this.y, 70, 70);
/* 592 */       this.contentPanel.add(this.btn[this.ind]);
/*     */       
/* 594 */       this.x += 80;
/* 595 */       if (this.x > 410) {
/* 596 */         this.x = 10;
/* 597 */         this.y += 81;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void reiniciar_botoes() {
/* 603 */     for (int i = 1; i <= 36; i++) {
/* 604 */       this.btn[i].setEnabled(true);
/* 605 */       this.btn[i].setIcon(null);
/* 606 */       this.btn[i].repaint();
/*     */     }
/*     */   }
/*     */   
/*     */   public void testar_acerto(int indice_botao) {
/* 611 */     this.ind = indice_botao;
/* 612 */     if (this.btn_aberto == this.ind) {
/* 613 */       this.btn[this.ind].setIcon(null);
/* 614 */       this.btn_aberto = 0;
/*     */     } else {
/*     */       try {
/* 617 */         this.btn[this.ind].setIcon(new ImageIcon(MemDirectXTelaTst.class.getResource(this.imagem_botao[this.ind])));
/*     */       } catch (Exception e) {
/* 619 */         e.printStackTrace();
/* 620 */         JOptionPane.showMessageDialog(null, "Imagens não localizadas! Fale com o desenvolvedor.");
/* 621 */         this.caminho_imagens = "linguagens/";
/* 622 */         reiniciar_botoes();
/* 623 */         reiniciar();
/*     */       }
/* 625 */       if (this.btn_aberto != 0) {
/* 626 */         String[] comp = this.imagem_botao[this.ind].split("_");
/* 627 */         String[] comp_aux = this.imagem_botao[this.btn_aberto].split("_");
/* 628 */         if (comp[1].equals(comp_aux[1]))
/*     */         {
/* 630 */           this.btn[this.ind].setEnabled(false);
/* 631 */           this.btn[this.btn_aberto].setEnabled(false);
/* 632 */           this.btn_aberto = 0;
/* 633 */           this.pontuacao += 50;
/* 634 */           this.lblPontuacao.setText(Integer.toString(this.pontuacao));
/* 635 */           this.acertos += 2;
/* 636 */           if (this.acertos == 36) {
/* 637 */             this.timer.stop();
/* 638 */             salvar_ranking(Integer.parseInt(this.lblPontuacao.getText()));
/*     */             try {
/* 640 */               mostrar_ranking(caminho_ranking);
/*     */             } catch (IOException e1) {
/* 642 */               e1.printStackTrace();
/*     */             }
/* 644 */             Object[] options = { "Sim", "Não" };
/* 645 */             int n = JOptionPane.showOptionDialog(null, "Parabéns, você ganhou. Deseja tentar novamente?", 
/* 646 */               "Parabéns!", 0, 3, null, options, 
/* 647 */               options[0]);
/*     */             
/* 649 */             if (n == 0) {
/* 650 */               reiniciar_botoes();
/* 651 */               reiniciar();
/*     */             }
/*     */           }
/*     */         }
/*     */         else {
/* 656 */           errou = true;
/*     */         }
/*     */       }
/*     */       else {
/* 660 */         this.btn_aberto = this.ind;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void testar_erro(int indice_botao)
/*     */   {
/* 667 */     this.ind = indice_botao;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 673 */     if (errou) {
/* 674 */       this.btn[this.ind].setIcon(null);
/* 675 */       this.btn[this.btn_aberto].setIcon(null);
/* 676 */       this.btn_aberto = 0;
/* 677 */       errou = false;
/* 678 */       this.pontuacao -= 5;
/* 679 */       if (this.pontuacao <= 0) {
/* 680 */         this.pontuacao = 0;
/*     */       }
/* 682 */       this.lblPontuacao.setText(Integer.toString(this.pontuacao));
/*     */     }
/*     */   }
/*     */   
/*     */   class tempo implements ActionListener {
/*     */     tempo() {}
/*     */     
/*     */     public void actionPerformed(ActionEvent e) {
/* 690 */       if (MemDirectXTelaTst.this.seg == 60) { MemDirectXTelaTst.this.min += 1;MemDirectXTelaTst.this.seg = 0; }
/* 691 */       if (MemDirectXTelaTst.this.min == 60) { MemDirectXTelaTst.this.hor += 1;MemDirectXTelaTst.this.min = 0; }
/* 692 */       MemDirectXTelaTst.this.seg += 1;
/* 693 */       if (MemDirectXTelaTst.this.hor == 24) MemDirectXTelaTst.this.hor = 0;
/* 694 */       if (MemDirectXTelaTst.this.seg < 10) MemDirectXTelaTst.this.st[0] = "0"; else MemDirectXTelaTst.this.st[0] = "";
/* 695 */       if (MemDirectXTelaTst.this.min < 10) MemDirectXTelaTst.this.st[1] = "0"; else MemDirectXTelaTst.this.st[1] = "";
/* 696 */       if (MemDirectXTelaTst.this.hor < 10) MemDirectXTelaTst.this.st[2] = "0"; else MemDirectXTelaTst.this.st[2] = "";
/* 697 */       MemDirectXTelaTst.this.lblTempo.setText(MemDirectXTelaTst.this.st[2] + Integer.toString(MemDirectXTelaTst.this.hor) + 
/* 698 */         ":" + MemDirectXTelaTst.this.st[1] + Integer.toString(MemDirectXTelaTst.this.min) + 
/* 699 */         ":" + MemDirectXTelaTst.this.st[0] + Integer.toString(MemDirectXTelaTst.this.seg));
/*     */     }
/*     */   }
/*     */   
/*     */   private class CliqueListener extends MouseAdapter {
/*     */     private int indice_btn;
/*     */     
/* 706 */     public CliqueListener(int indice_btn) { this.indice_btn = indice_btn; }
/*     */     
/*     */     public void mouseExited(MouseEvent arg0)
/*     */     {
/* 710 */       MemDirectXTelaTst.this.testar_erro(this.indice_btn);
/*     */     }
/*     */   }
/*     */   
/*     */   public void mudar_aparencia() {
/* 715 */     Color color = Color.LIGHT_GRAY;
/* 716 */     color = JColorChooser.showDialog(
/* 717 */       this, "Escolher a cor", color);
/* 718 */     if (color == null) {
/* 719 */       color = Color.WHITE;
/*     */     }
/* 721 */     for (int i = 1; i <= 36; i++) {
/* 722 */       this.btn[i].setBackground(color);
/*     */     }
/*     */   }
/*     */   
/*     */   public void mudar_imagens() {
/* 727 */     Object[] possibilidades = { "Alfabeto", "Linguagens", "Avengers" };
/* 728 */     String s = (String)JOptionPane.showInputDialog(
/* 729 */       null, 
/* 730 */       "Escolha um grupo", 
/* 731 */       "Mudar Imagens", 
/* 732 */       -1, 
/* 733 */       null, 
/* 734 */       possibilidades, 
/* 735 */       "Alfabeto");
/*     */     
/*     */ 
/* 738 */     if ((s != null) && (s.length() > 0)) {
/* 739 */       if (s.equals("Alfabeto")) {
/* 740 */         this.caminho_imagens = "alfabeto/";
/* 741 */       } else if (s.equals("Linguagens")) {
/* 742 */         this.caminho_imagens = "linguagens/";
/* 743 */       } else if (s.equals("Avengers")) {
/* 744 */         this.caminho_imagens = "avengers/";
/* 745 */       } else if (s.equals("Deadpool")) {
/* 746 */         this.caminho_imagens = "deadpool/";
/*     */       }
/*     */     }
/*     */     
/* 750 */     reiniciar_botoes();
/* 751 */     reiniciar();
/*     */   }
/*     */   
/*     */   public static void salvar_ranking(int nova_pontuacao) {
/* 755 */     String[] array_linhas = new String[10];
/*     */     
/* 757 */     String caminho = caminho_ranking;
/*     */     try {
/* 759 */       array_linhas = leitor(caminho);
/*     */     } catch (IOException e) {
/* 761 */       e.printStackTrace();
/*     */     }
/*     */     
/* 764 */     array_linhas[9] = ("9°. " + Integer.toString(nova_pontuacao));
/* 765 */     double[] tmp = new double[10];
/* 766 */     int[] pontuacao = new int[10];
/* 767 */     for (int i = 0; i < array_linhas.length; i++) {
/* 768 */       if (array_linhas[i] != null) {
/* 769 */         String[] array = array_linhas[i].split(" ");
/* 770 */         if (array_linhas[i].length() > 1) {
/* 771 */           pontuacao[i] = Integer.parseInt(array[1]);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 778 */     Arrays.sort(pontuacao);
/* 779 */     Arrays.sort(tmp);
/*     */     
/* 781 */     int j = 0;
/* 782 */     for (int i = pontuacao.length - 1; i > 0; i--) {
/* 783 */       array_linhas[(j + 1)] = (j + 1 + "°. " + pontuacao[i]);
/* 784 */       j++;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 796 */       escritor(caminho, array_linhas);
/*     */     } catch (IOException e) {
/* 798 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public static String[] leitor(String path) throws IOException
/*     */   {
/* 804 */     File arquivo = new File(caminho_ranking);
/* 805 */     if (!arquivo.exists())
/*     */     {
/*     */       try
/*     */       {
/* 809 */         FileWriter localFileWriter = new FileWriter(caminho_ranking);
/*     */       } catch (IOException e) {
/* 811 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 814 */     BufferedReader buffRead = new BufferedReader(new FileReader(path));
/* 815 */     String linha = "";
/* 816 */     String[] array_linha = new String[10];
/* 817 */     int i = 0;
/*     */     
/* 819 */     while (linha != null)
/*     */     {
/* 821 */       if (i < 10) {
/* 822 */         array_linha[i] = linha;
/* 823 */         i++;
/*     */       }
/*     */       
/*     */ 
/* 827 */       linha = buffRead.readLine();
/*     */     }
/* 829 */     buffRead.close();
/* 830 */     return array_linha;
/*     */   }
/*     */   
/*     */   public static void escritor(String path, String[] array) throws IOException {
/* 834 */     BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
/* 835 */     for (int i = 0; i < array.length; i++) {
/* 836 */       buffWrite.append(array[i]);
/* 837 */       buffWrite.append("\r\n");
/*     */     }
/* 839 */     buffWrite.close();
/*     */   }
/*     */   
/*     */   public static void mostrar_ranking(String path) throws IOException {
/* 843 */     File arquivo = new File(caminho_ranking);
/* 844 */     if (!arquivo.exists())
/*     */     {
/*     */       try
/*     */       {
/* 848 */         FileWriter localFileWriter = new FileWriter(caminho_ranking);
/*     */       } catch (IOException e) {
/* 850 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 853 */     BufferedReader buffRead = new BufferedReader(new FileReader(path));
/* 854 */     String linha = "";
/* 855 */     String[] array_linha = new String[10];
/* 856 */     int i = 0;
/*     */     
/* 858 */     while (linha != null)
/*     */     {
/*     */ 
/* 861 */       if (i < 10) {
/* 862 */         array_linha[i] = linha;
/* 863 */         i++;
/*     */       }
/*     */       
/*     */ 
/* 867 */       linha = buffRead.readLine();
/*     */     }
/* 869 */     buffRead.close();
/*     */     
/* 871 */     String a = "Ranking de Pontuação";
/* 872 */     for (int j = 0; j < 10; j++) {
/* 873 */       a = a + array_linha[j] + "\n";
/*     */     }
/*     */     
/* 876 */     JOptionPane.showMessageDialog(null, a, "Ranking", 1);
/*     */   }
/*     */ }


/* Location:              C:\Users\CamerasFazenda\Desktop\Mem.jar!\principal\MemDirectXTelaTst.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */