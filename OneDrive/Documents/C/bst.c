//Binary Search Tree Traversals
#include<stdio.h>  
#include<stdlib.h>  
  
struct node  
{  
    int key;  
    struct node *left;  
    struct node *right;  
};  
  
//return a new node with the given value  
struct node *getNode(int val)  
{  
    struct node *newNode;  
  
    newNode = malloc(sizeof(struct node));  
  
    newNode->key   = val;  
    newNode->left  = NULL;  
    newNode->right = NULL;  
  
    return newNode;  
}  
  
//inserts nodes in the binary search tree  
struct node *insertNode(struct node *root, int val)  
{  
     if(root == NULL)  
         return getNode(val);  
  
     if(root->key < val)  
         root->right = insertNode(root->right,val);  
  
     if(root->key > val)  
         root->left = insertNode(root->left,val);  
  
     return root;  
}  
  
//inorder traversal of the binary search tree  
void inorder(struct node *root)  
{  
    if(root == NULL)  
        return;  
  
    //traverse the left subtree  
    inorder(root->left);  
  
    //visit the root  
    printf("%d ",root->key);  
  
    //traverse the right subtree  
    inorder(root->right);  
}  
//preorder traversal of the binary search tree  
void preorder(struct node *root)  
{  
    if(root == NULL)  
        return;  
  
    //visit the root  
    printf("%d ",root->key);  
  
    //traverse the left subtree  
    preorder(root->left);  
  
    //traverse the right subtree  
    preorder(root->right);  
}  
//postorder traversal of the binary search tree  
  void postorder(struct node *root)  
{  
    if(root == NULL)  
        return;  
  
    //traverse the left subtree  
    postorder(root->left);  
  
    //traverse the right subtree  
    postorder(root->right);  
  
    //visit the root  
    printf("%d ",root->key);  
}  
int main()  
{  
   struct node *root = NULL;  
    int data;  
    char ch;  
      
        do      
        {  
            printf("\n-------------------------------------------");
            printf("\nSelect one of the operations::");  
            printf("\n1. To insert a new node in the Binary Tree");  
            printf("\n2. To display the nodes of the Bst(Inorder).");  
            printf("\n3. To display the nodes of the Bst(Preorder).");
            printf("\n4. To display the nodes of the Bst(postorder)");  
  
            int choice;  
            scanf("%d",&choice);              
            switch (choice)  
            {  
            case 1 :   
                printf("\nEnter the value to be inserted\n");  
                scanf("%d",&data);  
                root = insertNode(root,data);                    
                break;                            
            case 2 :   
  printf("\nInorder Traversal of the Binary Tree::\n");  
                inorder(root);  
                break;   
                 case 3:   
  printf("\nPreorder Traversal of the Binary Tree::\n");  
                preorder(root);  
                break;   
                 case 4 :   
  printf("\nPostorder Traversal of the Binary Tree::\n");  
                postorder(root);  
                break;   
            default :   
                printf("Wrong Entry\n");  
                break;     
            }  
  
            printf("\nDo you want to continue (Type y or n)\n");  
            scanf(" %c",&ch);                          
        } while (ch == 'Y'|| ch == 'y');  
  
   return 0;  
}  