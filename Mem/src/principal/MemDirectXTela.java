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
/*     */ import javax.swing.JSeparator;
/*     */ import javax.swing.Timer;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ 
/*     */ 
/*     */ public class MemDirectXTela
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
/*  65 */       MemDirectXTela dialog = new MemDirectXTela();
/*  66 */       dialog.setDefaultCloseOperation(2);
/*  67 */       dialog.setVisible(true);
/*     */     } catch (Exception e) {
/*  69 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public MemDirectXTela() {
/*  74 */     setBounds(100, 100, 598, 540);
/*  75 */     getContentPane().setLayout(new BorderLayout());
/*  76 */     this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  77 */     getContentPane().add(this.contentPanel, "Center");
/*  78 */     this.contentPanel.setLayout(null);
/*     */     
/*  80 */     setLocationRelativeTo(null);
/*  81 */     setModal(true);
/*     */     
/*  83 */     JButton btnReiniciar = new JButton("Reiniciar");
/*  84 */     btnReiniciar.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  86 */         MemDirectXTela.this.reiniciar_botoes();
/*  87 */         MemDirectXTela.this.reiniciar();
/*     */       }
/*  89 */     });
/*  90 */     btnReiniciar.setBounds(491, 100, 87, 43);
/*  91 */     this.contentPanel.add(btnReiniciar);
/*     */     
/*  93 */     JButton btnSair = new JButton("Sair");
/*  94 */     btnSair.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*  97 */         MemDirectXTela.this.dispose();
/*     */       }
/*  99 */     });
/* 100 */     btnSair.setBounds(491, 449, 87, 43);
/* 101 */     this.contentPanel.add(btnSair);
/*     */     
/* 103 */     this.lblTempo = new JLabel("00:00:00");
/* 104 */     this.lblTempo.setHorizontalAlignment(0);
/* 105 */     this.lblTempo.setBounds(491, 215, 87, 14);
/* 106 */     this.contentPanel.add(this.lblTempo);
/*     */     
/* 108 */     JLabel lblNewLabel = new JLabel("Tempo");
/* 109 */     lblNewLabel.setHorizontalAlignment(0);
/* 110 */     lblNewLabel.setBounds(491, 198, 87, 14);
/* 111 */     this.contentPanel.add(lblNewLabel);
/*     */     
/* 113 */     JLabel lblPontuao = new JLabel("Pontuação");
/* 114 */     lblPontuao.setHorizontalAlignment(0);
/* 115 */     lblPontuao.setBounds(491, 240, 87, 14);
/* 116 */     this.contentPanel.add(lblPontuao);
/*     */     
/* 118 */     this.lblPontuacao = new JLabel("0");
/* 119 */     this.lblPontuacao.setHorizontalAlignment(0);
/* 120 */     this.lblPontuacao.setBounds(491, 255, 87, 14);
/* 121 */     this.contentPanel.add(this.lblPontuacao);
/*     */     
/* 123 */     JButton btnMudarCor = new JButton("Cor");
/* 124 */     btnMudarCor.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 126 */         MemDirectXTela.this.mudar_aparencia();
/*     */       }
/* 128 */     });
/* 129 */     btnMudarCor.setBounds(491, 6, 87, 43);
/* 130 */     this.contentPanel.add(btnMudarCor);
/*     */     
/* 132 */     JButton btnNewButton_1 = new JButton("Tema");
/* 133 */     btnNewButton_1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 135 */         MemDirectXTela.this.mudar_imagens();
/*     */       }
/* 137 */     });
/* 138 */     btnNewButton_1.setBounds(491, 53, 87, 43);
/* 139 */     this.contentPanel.add(btnNewButton_1);
/*     */     
/* 141 */     JSeparator separator = new JSeparator();
/* 142 */     separator.setOrientation(1);
/* 143 */     separator.setBounds(485, 6, 1, 486);
/* 144 */     this.contentPanel.add(separator);
/*     */     
/* 146 */     JSeparator separator_1 = new JSeparator();
/* 147 */     separator_1.setBounds(4, 491, 482, 1);
/* 148 */     this.contentPanel.add(separator_1);
/*     */     
/* 150 */     JSeparator separator_2 = new JSeparator();
/* 151 */     separator_2.setBounds(4, 5, 482, 1);
/* 152 */     this.contentPanel.add(separator_2);
/*     */     
/* 154 */     JSeparator separator_3 = new JSeparator();
/* 155 */     separator_3.setOrientation(1);
/* 156 */     separator_3.setBounds(4, 6, 1, 486);
/* 157 */     this.contentPanel.add(separator_3);
/*     */     
/* 159 */     botoes();
/*     */     
/* 161 */     this.btn[1].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 163 */         MemDirectXTela.this.testar_acerto(1);
/*     */       }
/*     */       
/* 166 */     });
/* 167 */     this.btn[2].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 169 */         MemDirectXTela.this.testar_acerto(2);
/*     */       }
/*     */       
/* 172 */     });
/* 173 */     this.btn[3].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 175 */         MemDirectXTela.this.testar_acerto(3);
/*     */       }
/*     */       
/* 178 */     });
/* 179 */     this.btn[4].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 181 */         MemDirectXTela.this.testar_acerto(4);
/*     */       }
/*     */       
/* 184 */     });
/* 185 */     this.btn[5].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 187 */         MemDirectXTela.this.testar_acerto(5);
/*     */       }
/*     */       
/* 190 */     });
/* 191 */     this.btn[6].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 193 */         MemDirectXTela.this.testar_acerto(6);
/*     */       }
/*     */       
/* 196 */     });
/* 197 */     this.btn[7].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 199 */         MemDirectXTela.this.testar_acerto(7);
/*     */       }
/*     */       
/* 202 */     });
/* 203 */     this.btn[8].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 205 */         MemDirectXTela.this.testar_acerto(8);
/*     */       }
/*     */       
/* 208 */     });
/* 209 */     this.btn[9].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 211 */         MemDirectXTela.this.testar_acerto(9);
/*     */       }
/*     */       
/* 214 */     });
/* 215 */     this.btn[10].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 217 */         MemDirectXTela.this.testar_acerto(10);
/*     */       }
/*     */       
/* 220 */     });
/* 221 */     this.btn[11].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 223 */         MemDirectXTela.this.testar_acerto(11);
/*     */       }
/*     */       
/* 226 */     });
/* 227 */     this.btn[12].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 229 */         MemDirectXTela.this.testar_acerto(12);
/*     */       }
/*     */       
/* 232 */     });
/* 233 */     this.btn[13].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 235 */         MemDirectXTela.this.testar_acerto(13);
/*     */       }
/*     */       
/* 238 */     });
/* 239 */     this.btn[14].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 241 */         MemDirectXTela.this.testar_acerto(14);
/*     */       }
/*     */       
/* 244 */     });
/* 245 */     this.btn[15].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 247 */         MemDirectXTela.this.testar_acerto(15);
/*     */       }
/*     */       
/* 250 */     });
/* 251 */     this.btn[16].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 253 */         MemDirectXTela.this.testar_acerto(16);
/*     */       }
/*     */       
/* 256 */     });
/* 257 */     this.btn[17].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 259 */         MemDirectXTela.this.testar_acerto(17);
/*     */       }
/*     */       
/* 262 */     });
/* 263 */     this.btn[18].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 265 */         MemDirectXTela.this.testar_acerto(18);
/*     */       }
/*     */       
/* 268 */     });
/* 269 */     this.btn[19].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 271 */         MemDirectXTela.this.testar_acerto(19);
/*     */       }
/*     */       
/* 274 */     });
/* 275 */     this.btn[20].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 277 */         MemDirectXTela.this.testar_acerto(20);
/*     */       }
/*     */       
/* 280 */     });
/* 281 */     this.btn[21].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 283 */         MemDirectXTela.this.testar_acerto(21);
/*     */       }
/*     */       
/* 286 */     });
/* 287 */     this.btn[22].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 289 */         MemDirectXTela.this.testar_acerto(22);
/*     */       }
/*     */       
/* 292 */     });
/* 293 */     this.btn[23].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 295 */         MemDirectXTela.this.testar_acerto(23);
/*     */       }
/*     */       
/* 298 */     });
/* 299 */     this.btn[24].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 301 */         MemDirectXTela.this.testar_acerto(24);
/*     */       }
/*     */       
/* 304 */     });
/* 305 */     this.btn[25].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 307 */         MemDirectXTela.this.testar_acerto(25);
/*     */       }
/*     */       
/* 310 */     });
/* 311 */     this.btn[26].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 313 */         MemDirectXTela.this.testar_acerto(26);
/*     */       }
/*     */       
/* 316 */     });
/* 317 */     this.btn[27].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 319 */         MemDirectXTela.this.testar_acerto(27);
/*     */       }
/*     */       
/* 322 */     });
/* 323 */     this.btn[28].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 325 */         MemDirectXTela.this.testar_acerto(28);
/*     */       }
/*     */       
/* 328 */     });
/* 329 */     this.btn[29].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 331 */         MemDirectXTela.this.testar_acerto(29);
/*     */       }
/*     */       
/* 334 */     });
/* 335 */     this.btn[30].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 337 */         MemDirectXTela.this.testar_acerto(30);
/*     */       }
/*     */       
/* 340 */     });
/* 341 */     this.btn[31].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 343 */         MemDirectXTela.this.testar_acerto(31);
/*     */       }
/*     */       
/* 346 */     });
/* 347 */     this.btn[32].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 349 */         MemDirectXTela.this.testar_acerto(32);
/*     */       }
/*     */       
/* 352 */     });
/* 353 */     this.btn[33].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 355 */         MemDirectXTela.this.testar_acerto(33);
/*     */       }
/*     */       
/* 358 */     });
/* 359 */     this.btn[34].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 361 */         MemDirectXTela.this.testar_acerto(34);
/*     */       }
/*     */       
/* 364 */     });
/* 365 */     this.btn[35].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 367 */         MemDirectXTela.this.testar_acerto(35);
/*     */       }
/*     */       
/* 370 */     });
/* 371 */     this.btn[36].addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 373 */         MemDirectXTela.this.testar_acerto(36);
/*     */       }
/*     */       
/* 376 */     });
/* 377 */     this.btn[1].addMouseListener(new CliqueListener(1));
/* 378 */     this.btn[2].addMouseListener(new CliqueListener(2));
/* 379 */     this.btn[3].addMouseListener(new CliqueListener(3));
/* 380 */     this.btn[4].addMouseListener(new CliqueListener(4));
/* 381 */     this.btn[5].addMouseListener(new CliqueListener(5));
/* 382 */     this.btn[6].addMouseListener(new CliqueListener(6));
/* 383 */     this.btn[7].addMouseListener(new CliqueListener(7));
/* 384 */     this.btn[8].addMouseListener(new CliqueListener(8));
/* 385 */     this.btn[9].addMouseListener(new CliqueListener(9));
/* 386 */     this.btn[10].addMouseListener(new CliqueListener(10));
/* 387 */     this.btn[11].addMouseListener(new CliqueListener(11));
/* 388 */     this.btn[12].addMouseListener(new CliqueListener(12));
/* 389 */     this.btn[13].addMouseListener(new CliqueListener(13));
/* 390 */     this.btn[14].addMouseListener(new CliqueListener(14));
/* 391 */     this.btn[15].addMouseListener(new CliqueListener(15));
/* 392 */     this.btn[16].addMouseListener(new CliqueListener(16));
/* 393 */     this.btn[17].addMouseListener(new CliqueListener(17));
/* 394 */     this.btn[18].addMouseListener(new CliqueListener(18));
/* 395 */     this.btn[19].addMouseListener(new CliqueListener(19));
/* 396 */     this.btn[20].addMouseListener(new CliqueListener(20));
/* 397 */     this.btn[21].addMouseListener(new CliqueListener(21));
/* 398 */     this.btn[22].addMouseListener(new CliqueListener(22));
/* 399 */     this.btn[23].addMouseListener(new CliqueListener(23));
/* 400 */     this.btn[24].addMouseListener(new CliqueListener(24));
/* 401 */     this.btn[25].addMouseListener(new CliqueListener(25));
/* 402 */     this.btn[26].addMouseListener(new CliqueListener(26));
/* 403 */     this.btn[27].addMouseListener(new CliqueListener(27));
/* 404 */     this.btn[28].addMouseListener(new CliqueListener(28));
/* 405 */     this.btn[29].addMouseListener(new CliqueListener(29));
/* 406 */     this.btn[30].addMouseListener(new CliqueListener(30));
/* 407 */     this.btn[31].addMouseListener(new CliqueListener(31));
/* 408 */     this.btn[32].addMouseListener(new CliqueListener(32));
/* 409 */     this.btn[33].addMouseListener(new CliqueListener(33));
/* 410 */     this.btn[34].addMouseListener(new CliqueListener(34));
/* 411 */     this.btn[35].addMouseListener(new CliqueListener(35));
/* 412 */     this.btn[36].addMouseListener(new CliqueListener(36));
/*     */     
/* 414 */     this.timer = new Timer(1000, new tempo());
/* 415 */     this.timer.start();
/*     */     try
/*     */     {
/* 418 */       reiniciar();
/*     */     } catch (Exception e) {
/* 420 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void reiniciar() {
/* 425 */     List<Integer> numeros = new ArrayList();
/* 426 */     for (int i = 1; i <= 36; i++) {
/* 427 */       numeros.add(Integer.valueOf(i));
/*     */     }
/*     */     
/* 430 */     Collections.shuffle(numeros);
/*     */     
/*     */ 
/* 433 */     String letra = "";
/* 434 */     int j = 1;
/* 435 */     for (int i = 0; i < 36; i++)
/*     */     {
/* 437 */       letra = buscarLetra(((Integer)numeros.get(i)).intValue());
/* 438 */       this.imagem_botao[j] = ("/ImagensMem/" + this.caminho_imagens + numeros.get(i) + "_" + letra + ".PNG");
/*     */       
/* 440 */       j++;
/*     */     }
/*     */     
/* 443 */     this.btn_aberto = 0;
/* 444 */     errou = false;
/* 445 */     this.ind = 0;
/* 446 */     this.x = 10;
/* 447 */     this.y = 11;
/* 448 */     this.pontuacao = 0;
/* 449 */     this.lblPontuacao.setText(Integer.toString(this.pontuacao));
/* 450 */     this.acertos = 0;
/* 451 */     this.hor = 0;
/* 452 */     this.min = 0;
/* 453 */     this.seg = 0;
/* 454 */     this.timer.restart();
/*     */   }
/*     */   
/*     */   public String buscarLetra(int num) {
/* 458 */     if (num != 0) {
/* 459 */       if ((num == 1) || (num == 2))
/* 460 */         return "A";
/* 461 */       if ((num == 3) || (num == 4))
/* 462 */         return "B";
/* 463 */       if ((num == 5) || (num == 6))
/* 464 */         return "C";
/* 465 */       if ((num == 7) || (num == 8))
/* 466 */         return "D";
/* 467 */       if ((num == 9) || (num == 10))
/* 468 */         return "E";
/* 469 */       if ((num == 11) || (num == 12))
/* 470 */         return "F";
/* 471 */       if ((num == 13) || (num == 14))
/* 472 */         return "G";
/* 473 */       if ((num == 15) || (num == 16))
/* 474 */         return "H";
/* 475 */       if ((num == 17) || (num == 18))
/* 476 */         return "I";
/* 477 */       if ((num == 19) || (num == 20))
/* 478 */         return "J";
/* 479 */       if ((num == 21) || (num == 22))
/* 480 */         return "K";
/* 481 */       if ((num == 23) || (num == 24))
/* 482 */         return "L";
/* 483 */       if ((num == 25) || (num == 26))
/* 484 */         return "M";
/* 485 */       if ((num == 27) || (num == 28))
/* 486 */         return "N";
/* 487 */       if ((num == 29) || (num == 30))
/* 488 */         return "O";
/* 489 */       if ((num == 31) || (num == 32))
/* 490 */         return "P";
/* 491 */       if ((num == 33) || (num == 34))
/* 492 */         return "Q";
/* 493 */       if ((num == 35) || (num == 36)) {
/* 494 */         return "R";
/*     */       }
/*     */     }
/* 497 */     return "";
/*     */   }
/*     */   
/*     */   public void botoes() {
/* 501 */     for (int i = 1; i <= 36; i++) {
/* 502 */       this.ind = i;
/* 503 */       this.btn[this.ind] = new JButton("");
/* 504 */       this.btn[this.ind].setBounds(this.x, this.y, 70, 70);
/* 505 */       this.contentPanel.add(this.btn[this.ind]);
/*     */       
/* 507 */       this.x += 80;
/* 508 */       if (this.x > 410) {
/* 509 */         this.x = 10;
/* 510 */         this.y += 81;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void reiniciar_botoes() {
/* 516 */     for (int i = 1; i <= 36; i++) {
/* 517 */       this.btn[i].setEnabled(true);
/* 518 */       this.btn[i].setIcon(null);
/* 519 */       this.btn[i].repaint();
/*     */     }
/*     */   }
/*     */   
/*     */   public void testar_acerto(int indice_botao) {
/* 524 */     this.ind = indice_botao;
/* 525 */     if (this.btn_aberto == this.ind) {
/* 526 */       this.btn[this.ind].setIcon(null);
/* 527 */       this.btn_aberto = 0;
/*     */     } else {
/*     */       try {
/* 530 */         this.btn[this.ind].setIcon(new ImageIcon(MemDirectXTela.class.getResource(this.imagem_botao[this.ind])));
/*     */       } catch (Exception e) {
/* 532 */         e.printStackTrace();
/* 533 */         JOptionPane.showMessageDialog(null, "Imagens não localizadas! Fale com o desenvolvedor.");
/* 534 */         this.caminho_imagens = "linguagens/";
/* 535 */         reiniciar_botoes();
/* 536 */         reiniciar();
/*     */       }
/* 538 */       if (this.btn_aberto != 0) {
/* 539 */         String[] comp = this.imagem_botao[this.ind].split("_");
/* 540 */         String[] comp_aux = this.imagem_botao[this.btn_aberto].split("_");
/* 541 */         if (comp[1].equals(comp_aux[1]))
/*     */         {
/* 543 */           this.btn[this.ind].setEnabled(false);
/* 544 */           this.btn[this.btn_aberto].setEnabled(false);
/* 545 */           this.btn_aberto = 0;
/* 546 */           this.pontuacao += 50;
/* 547 */           this.lblPontuacao.setText(Integer.toString(this.pontuacao));
/* 548 */           this.acertos += 2;
/* 549 */           if (this.acertos == 36) {
/* 550 */             this.timer.stop();
/* 551 */             salvar_ranking(Integer.parseInt(this.lblPontuacao.getText()));
/*     */             try {
/* 553 */               mostrar_ranking(caminho_ranking);
/*     */             } catch (IOException e1) {
/* 555 */               e1.printStackTrace();
/*     */             }
/* 557 */             Object[] options = { "Sim", "Não" };
/* 558 */             int n = JOptionPane.showOptionDialog(null, "Parabéns, você ganhou. Deseja tentar novamente?", 
/* 559 */               "Parabéns!", 0, 3, null, options, 
/* 560 */               options[0]);
/*     */             
/* 562 */             if (n == 0) {
/* 563 */               reiniciar_botoes();
/* 564 */               reiniciar();
/*     */             }
/*     */           }
/*     */         }
/*     */         else {
/* 569 */           errou = true;
/*     */         }
/*     */       }
/*     */       else {
/* 573 */         this.btn_aberto = this.ind;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void testar_erro(int indice_botao)
/*     */   {
/* 580 */     this.ind = indice_botao;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 586 */     if (errou) {
/* 587 */       this.btn[this.ind].setIcon(null);
/* 588 */       this.btn[this.btn_aberto].setIcon(null);
/* 589 */       this.btn_aberto = 0;
/* 590 */       errou = false;
/* 591 */       this.pontuacao -= 5;
/* 592 */       if (this.pontuacao <= 0) {
/* 593 */         this.pontuacao = 0;
/*     */       }
/* 595 */       this.lblPontuacao.setText(Integer.toString(this.pontuacao));
/*     */     }
/*     */   }
/*     */   
/*     */   class tempo implements ActionListener {
/*     */     tempo() {}
/*     */     
/*     */     public void actionPerformed(ActionEvent e) {
/* 603 */       if (MemDirectXTela.this.seg == 60) { MemDirectXTela.this.min += 1;MemDirectXTela.this.seg = 0; }
/* 604 */       if (MemDirectXTela.this.min == 60) { MemDirectXTela.this.hor += 1;MemDirectXTela.this.min = 0; }
/* 605 */       MemDirectXTela.this.seg += 1;
/* 606 */       if (MemDirectXTela.this.hor == 24) MemDirectXTela.this.hor = 0;
/* 607 */       if (MemDirectXTela.this.seg < 10) MemDirectXTela.this.st[0] = "0"; else MemDirectXTela.this.st[0] = "";
/* 608 */       if (MemDirectXTela.this.min < 10) MemDirectXTela.this.st[1] = "0"; else MemDirectXTela.this.st[1] = "";
/* 609 */       if (MemDirectXTela.this.hor < 10) MemDirectXTela.this.st[2] = "0"; else MemDirectXTela.this.st[2] = "";
/* 610 */       MemDirectXTela.this.lblTempo.setText(MemDirectXTela.this.st[2] + Integer.toString(MemDirectXTela.this.hor) + 
/* 611 */         ":" + MemDirectXTela.this.st[1] + Integer.toString(MemDirectXTela.this.min) + 
/* 612 */         ":" + MemDirectXTela.this.st[0] + Integer.toString(MemDirectXTela.this.seg));
/*     */     }
/*     */   }
/*     */   
/*     */   private class CliqueListener extends MouseAdapter {
/*     */     private int indice_btn;
/*     */     
/* 619 */     public CliqueListener(int indice_btn) { this.indice_btn = indice_btn; }
/*     */     
/*     */     public void mouseExited(MouseEvent arg0)
/*     */     {
/* 623 */       MemDirectXTela.this.testar_erro(this.indice_btn);
/*     */     }
/*     */   }
/*     */   
/*     */   public void mudar_aparencia() {
/* 628 */     Color color = Color.LIGHT_GRAY;
/* 629 */     color = JColorChooser.showDialog(
/* 630 */       this, "Escolher a cor", color);
/* 631 */     if (color == null) {
/* 632 */       color = Color.WHITE;
/*     */     }
/* 634 */     for (int i = 1; i <= 36; i++) {
/* 635 */       this.btn[i].setBackground(color);
/*     */     }
/*     */   }
/*     */   
/*     */   public void mudar_imagens() {
/* 640 */     Object[] possibilidades = { "Alfabeto", "Linguagens", "Avengers" };
/* 641 */     String s = (String)JOptionPane.showInputDialog(
/* 642 */       null, 
/* 643 */       "Escolha um grupo", 
/* 644 */       "Mudar Imagens", 
/* 645 */       -1, 
/* 646 */       null, 
/* 647 */       possibilidades, 
/* 648 */       "Alfabeto");
/*     */     
/*     */ 
/* 651 */     if ((s != null) && (s.length() > 0)) {
/* 652 */       if (s.equals("Alfabeto")) {
/* 653 */         this.caminho_imagens = "alfabeto/";
/* 654 */       } else if (s.equals("Linguagens")) {
/* 655 */         this.caminho_imagens = "linguagens/";
/* 656 */       } else if (s.equals("Avengers")) {
/* 657 */         this.caminho_imagens = "avengers/";
/* 658 */       } else if (s.equals("Deadpool")) {
/* 659 */         this.caminho_imagens = "deadpool/";
/*     */       }
/*     */       
/* 662 */       reiniciar_botoes();
/* 663 */       reiniciar();
/*     */     }
/*     */   }
/*     */   
/*     */   public static void salvar_ranking(int nova_pontuacao) {
/* 668 */     String[] array_linhas = new String[10];
/*     */     
/* 670 */     String caminho = caminho_ranking;
/*     */     try {
/* 672 */       array_linhas = leitor(caminho);
/*     */     } catch (IOException e) {
/* 674 */       e.printStackTrace();
/*     */     }
/*     */     
/* 677 */     array_linhas[9] = ("9°. " + Integer.toString(nova_pontuacao));
/* 678 */     double[] tmp = new double[10];
/* 679 */     int[] pontuacao = new int[10];
/* 680 */     for (int i = 0; i < array_linhas.length; i++) {
/* 681 */       if (array_linhas[i] != null) {
/* 682 */         String[] array = array_linhas[i].split(" ");
/* 683 */         if (array_linhas[i].length() > 1) {
/* 684 */           pontuacao[i] = Integer.parseInt(array[1]);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 691 */     Arrays.sort(pontuacao);
/* 692 */     Arrays.sort(tmp);
/*     */     
/* 694 */     int j = 0;
/* 695 */     for (int i = pontuacao.length - 1; i > 0; i--) {
/* 696 */       array_linhas[(j + 1)] = (j + 1 + "°. " + pontuacao[i]);
/* 697 */       j++;
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
/* 709 */       escritor(caminho, array_linhas);
/*     */     } catch (IOException e) {
/* 711 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public static String[] leitor(String path) throws IOException
/*     */   {
/* 717 */     File arquivo = new File(caminho_ranking);
/* 718 */     if (!arquivo.exists())
/*     */     {
/*     */       try
/*     */       {
/* 722 */         FileWriter localFileWriter = new FileWriter(caminho_ranking);
/*     */       } catch (IOException e) {
/* 724 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 727 */     BufferedReader buffRead = new BufferedReader(new FileReader(path));
/* 728 */     String linha = "";
/* 729 */     String[] array_linha = new String[10];
/* 730 */     int i = 0;
/*     */     
/* 732 */     while (linha != null)
/*     */     {
/* 734 */       if (i < 10) {
/* 735 */         array_linha[i] = linha;
/* 736 */         i++;
/*     */       }
/*     */       
/*     */ 
/* 740 */       linha = buffRead.readLine();
/*     */     }
/* 742 */     buffRead.close();
/* 743 */     return array_linha;
/*     */   }
/*     */   
/*     */   public static void escritor(String path, String[] array) throws IOException {
/* 747 */     BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
/* 748 */     for (int i = 0; i < array.length; i++) {
/* 749 */       buffWrite.append(array[i]);
/* 750 */       buffWrite.append("\r\n");
/*     */     }
/* 752 */     buffWrite.close();
/*     */   }
/*     */   
/*     */   public static void mostrar_ranking(String path) throws IOException {
/* 756 */     File arquivo = new File(caminho_ranking);
/* 757 */     if (!arquivo.exists())
/*     */     {
/*     */       try
/*     */       {
/* 761 */         FileWriter localFileWriter = new FileWriter(caminho_ranking);
/*     */       } catch (IOException e) {
/* 763 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 766 */     BufferedReader buffRead = new BufferedReader(new FileReader(path));
/* 767 */     String linha = "";
/* 768 */     String[] array_linha = new String[10];
/* 769 */     int i = 0;
/*     */     
/* 771 */     while (linha != null)
/*     */     {
/*     */ 
/* 774 */       if (i < 10) {
/* 775 */         array_linha[i] = linha;
/* 776 */         i++;
/*     */       }
/*     */       
/*     */ 
/* 780 */       linha = buffRead.readLine();
/*     */     }
/* 782 */     buffRead.close();
/*     */     
/* 784 */     String a = "Ranking de Pontuação";
/* 785 */     for (int j = 0; j < 10; j++) {
/* 786 */       a = a + array_linha[j] + "\n";
/*     */     }
/*     */     
/* 789 */     JOptionPane.showMessageDialog(null, a, "Ranking", 1);
/*     */   }
/*     */ }


/* Location:              C:\Users\CamerasFazenda\Desktop\Mem.jar!\principal\MemDirectXTela.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */