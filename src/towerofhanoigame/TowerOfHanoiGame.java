/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoigame;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Fery Eka Mahendra
 */
public class TowerOfHanoiGame {

    public static int N, NA, NB, NC, num;
    public static char dari, ke;
    public static Scanner input = new Scanner(System.in);
    public static Scanner scan = new Scanner(System.in);

    /* Membuat stack pada array */
    public static Stack<Integer>[] tower = new Stack[4];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        tower[1] = new Stack<Integer>();
        tower[2] = new Stack<Integer>();
        tower[3] = new Stack<Integer>();

        /* Accepting number of disks */
        System.out.println("Masukkan jumlah disks");
        num = scan.nextInt();
        N = num;
        toh(num);
    }

    /* Function untuk push disks kedalam stack */
    public static void toh(int n) {
        for (int d = n; d > 0; d--) {
            tower[1].push(d);
        }
        pindah();
    }

    /* Function untuk menampilkan */
    public static void display() {
        System.out.println("  A  |  B  |  C");
        System.out.println("---------------");
        for (int i = N - 1; i >= 0; i--) {
            String d1 = " ", d2 = " ", d3 = " ";
            try {
                d1 = String.valueOf(tower[1].get(i));
            } catch (Exception e) {
            }
            try {
                d2 = String.valueOf(tower[2].get(i));
            } catch (Exception e) {
            }
            try {
                d3 = String.valueOf(tower[3].get(i));
            } catch (Exception e) {
            }
            System.out.println("  " + d1 + "  |  " + d2 + "  |  " + d3);
        }
        System.out.println("\n");
    }

    static void pindah() {
        display();

        System.out.print("\nPindah disk dari : ");
        dari = input.next().charAt(0);

        //ignore case
        if (dari == 'a' || dari == 'A') {
            dari = 'A';
        } else if (dari == 'b' || dari == 'B') {
            dari = 'B';
        } else if (dari == 'c' || dari == 'C') {
            dari = 'C';
        } else {
            System.out.println("Pilihan tidak valid, ulangi");
            pindah();
        }
        System.out.print("ke : ");
        ke = input.next().charAt(0);
        if (ke == 'a' || ke == 'A') {
            ke = 'A';
        } else if (ke == 'b' || ke == 'B') {
            ke = 'B';
        } else if (ke == 'c' || ke == 'C') {
            ke = 'C';
        } else {
            System.out.println("Pilihan tidak valid, ulangi");
            pindah();
        }

//exception case 
        if (dari == ke) {
            System.out.println("tidak bisa memasukan Huruf yang sama, ulangi!");
            pindah();
        }

//pindah
        if (dari == 'A') {
            if (tower[1].isEmpty() == false) {
                NA = (int) tower[1].peek();
            }

            if (tower[1].isEmpty() == true) {
                System.out.println("Tower A kosong, ulangi");
                pindah();
            } else if (ke == 'B') {
                if (tower[2].isEmpty() == true) {
                    tower[2].push(tower[1].pop());
                } else {
                    NB = (int) tower[2].peek();
                    if (NA > NB) {
                        System.out.println("gagal, angka " + tower[1].peek() + " lebih besar dari " + tower[2].peek());
                        pindah();
                    } else if (NA < NB) {
                        tower[2].push(tower[1].pop());
                    }
                }
            } else if (ke == 'C') {
                if (tower[3].isEmpty() == true) {
                    tower[3].push(tower[1].pop());
                } else {
                    NC = (int) tower[3].peek();
                    if (NA > NC) {
                        System.out.println("gagal, angka " + tower[1].peek() + " lebih besar dari " + tower[3].peek());
                        pindah();
                    } else if (NA < NC) {
                        tower[3].push(tower[1].pop());
                    }
                }
            }
        } else if (dari == 'B') {

            if (tower[2].isEmpty() == false) {
                NB = (int) tower[2].peek();
            }

            if (tower[2].isEmpty() == true) {
                System.out.println("Tower B kosong, ulangi");
                pindah();
            } else if (ke == 'A') {
                if (tower[1].isEmpty() == true) {
                    tower[1].push(tower[2].pop());
                } else {
                    NA = (int) tower[1].peek();
                    if (NB > NA) {
                        System.out.println("gagal, angka " + tower[2].peek() + " lebih besar dari " + tower[1].peek());
                        pindah();
                    } else if (NB < NA) {
                        tower[1].push(tower[2].pop());
                    }
                }
            } else if (ke == 'C') {
                if (tower[3].isEmpty() == true) {
                    tower[3].push(tower[2].pop());
                } else {
                    NC = (int) tower[3].peek();
                    if (NB > NC) {
                        System.out.println("gagal, angka " + tower[2].peek() + " lebih besar dari " + tower[3].peek());
                        pindah();
                    } else if (NB < NC) {
                        tower[3].push(tower[2].pop());
                    }
                }
            }
        } else if (dari == 'C') {
            if (tower[3].isEmpty() == false) {
                NC = (int) tower[3].peek();
            }
            if (tower[3].isEmpty() == true) {
                System.out.println("Tower C kosong, ulangi");
                pindah();
            } else if (ke == 'B') {
                if (tower[2].isEmpty() == true) {
                    tower[2].push(tower[3].pop());
                } else {
                    NB = (int) tower[2].peek();
                    if (NC > NB) {
                        System.out.println("gagal, angka " + tower[3].peek() + " lebih besar dari " + tower[2].peek());
                        pindah();
                    } else if (NC < NB) {
                        tower[2].push(tower[3].pop());
                    }
                }
            } else if (ke == 'A') {
                if (tower[1].isEmpty() == true) {
                    tower[1].push(tower[3].pop());
                } else {
                    NA = (int) tower[1].peek();
                    if (NC > NA) {
                        System.out.println("gagal, angka " + tower[3].peek() + " lebih besar dari " + tower[1].peek());
                        pindah();
                    } else if (NC < NA) {
                        tower[1].push(tower[3].pop());
                    }
                }
            }
        }

        if (tower[1].isEmpty() == true && tower[2].isEmpty() == true) {
            System.out.println("game selesai!");
        } else {
            pindah();
        }

    }
}
