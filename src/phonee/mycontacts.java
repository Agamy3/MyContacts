/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonee;

/**
 *
 * @author Acer
 */
public class mycontacts {
    Node root;

    public mycontacts() {
   root=null;
    }
 public void insert(contact contact) {
        root = insertt(root, contact);
    }    
 public Node insertt(Node root,contact contact){
     if(root==null){
         root = new Node (contact);
         return root;
     }else if(contact.name.compareTo(root.contact.name)<0){
         root.left=insertt(root.left,contact);
         
     }else if(contact.name.compareTo(root.contact.name)>0){
         root.right=insertt(root.right,contact);
     } 
 
 return root;
 }
   public contact search(String name) {
        return search2(root, name);
    }
private contact search2(Node root, String name) {
    while (root != null) {
        int compareResult = name.compareTo(root.contact.name);
        
        if (compareResult == 0) {
            return root.contact;
        } else if (compareResult < 0) {
            root = root.left;
        } else {
            root = root.right;
        }
    }
    
    return null;
}

    public void traverse(Node root) {
        if (root != null) {
            traverse(root.left);
            System.out.println("Name: " + root.contact.name + ", Phone: " + root.contact.number);
            traverse(root.right);
        }
    }
    public void delete(String name) {
        root = delete2(root, name);
    }
        private Node delete2(Node root, String name) {
        if (root == null) {
            return root;
        }

        if (name.compareToIgnoreCase(root.contact.name) < 0) {
            root.left = delete2(root.left, name);
        } else if (name.compareToIgnoreCase(root.contact.name) > 0) {
            root.right = delete2(root.right, name);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.contact = minvalue(root.right).contact;
            root.right = delete2(root.right, root.contact.name);
        }

        return root;
    }
            private Node minvalue(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
