/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonee;

/**
 *
 * @author Acer
 */
public class Node {
        contact contact;
    Node left;
    Node right;
    public Node(contact contact){
        this.contact = contact;
        this.left = null;
        this.right = null;
    }
}
