#include<bits./stdc++.h>
using namespace std;

class Node{
private:
    int data;
    Node* next;
public:
    Node(int data)
    {
        this->data=data;
        this->next=nullptr;
    }
    Node(int data,Node* next)
    {
        this->data=data;
        this->next=next;
    }
    void setNext(Node* next)
    {
        this->next=next;
    }
    Node* getNext()
    {
        return this->next;
    }
    int getData()
    {
        return data;
    }
};

Node* convert2LL(vector<int>&arr)
{   
    if(arr.size()==0)return nullptr;
    Node* head=new Node(arr[0]);
    Node* mover=head;
    for(int i=1;i<arr.size();i++)
    {
        Node* temp=new Node(arr[i]);
        mover->setNext(temp);
        mover=temp;
    }

    return head;
}

void traverseArray(Node* head)
{
    Node* temp=head;
    while(temp!=nullptr)
    {
        cout<<temp->getData()<<" ";
        temp=temp->getNext();
    }
    cout<<endl;
}

int sizeOfLL(Node* head)
{
    Node* temp=head;
    int count=0;
    while(temp!=nullptr)
    {
        count++;
        temp=temp->getNext();
    }
    return count;
}

bool checkIfPresent(Node* head,int val)
{
    Node* temp=head;
    while(temp!=nullptr)
    {
        if(temp->getData()==val)return true;
        temp=temp->getNext();
    }
    return false;
}

Node* removehead(Node* head)
{
    if(head==nullptr)return nullptr;
    Node* temp=head;
    head=head->getNext();
    delete temp;
    return head;
}

Node* removetail(Node* head)
{
    if(head==nullptr)return nullptr;
    if(head->getNext()==nullptr)
    {
        delete head;
        return nullptr;
    }
    Node* temp=head;
    while(temp->getNext()->getNext()!=nullptr)
    {
        temp=temp->getNext();
    }
    delete temp->getNext();
    temp->setNext(nullptr);
    return head;
}

Node* removeAnyPos(Node* head,int k)
{
    if(head==nullptr)return nullptr;
    if(k==1)
    {
       
        //return removehead(head);
        Node* hea=removehead(head);
        return hea;//Can't use head..Redefinition of head
    }
    Node* temp=head;
    Node* prev=nullptr;
    int count=0;
    while(temp!=nullptr)
    {
        count++;
        if(count==k)
        {
            prev->setNext(temp->getNext());
            delete temp;
            break;
        }
        prev=temp;
        temp=temp->getNext();
    }
    return head;
}

Node* insertAtHead(Node* head,int val)
{
    Node* temp=new Node(val);
    temp->setNext(head);
    head=temp;
    return head;
}

Node* insertAtTail(Node* head,int val)
{
    if(head==nullptr)return new Node(val);
    Node* temp=head;
    while(temp->getNext()!=nullptr)
    {
        temp=temp->getNext();
    }
    Node* x=new Node(val);
    temp->setNext(x);
    return head;
}

Node* insertAnyPos(Node* head,int val,int k)
{
    if(head==nullptr)
    {
        Node* x=new Node(val);
        head=x;
        return head;
    }
    if(k==1)return insertAtHead(head,val);
    Node* temp=head;
    Node* prev=nullptr;
    int count=0;
    while(temp!=nullptr)
    {
        count++;
        if(count==k)
        {   
            Node* x=new Node(val);
            prev->setNext(x);
            x->setNext(temp);
            break;
        }
        prev=temp;
        temp=temp->getNext();
        
    }
    if(count+1==k)
    {
        prev->setNext(new Node(val));
    }

    return head;
}

Node* insertBeforeVal(Node* head,int val,int val1)
{
    if(head==nullptr)return nullptr;
    if(head->getData()==val1)return new Node(val,head);
    Node* temp=head;
    Node* prev=nullptr;
    while(temp!=nullptr)
    {
        if(temp->getData()==val1)
        {   
            Node* x=new Node(val);
            prev->setNext(x);
            x->setNext(temp);
            break;
        }
        prev=temp;
        temp=temp->getNext();
        
    }
    return head;
}

Node* reversell(Node* head)
{
    Node* temp=head;
    Node* x=nullptr;
    Node* prev=nullptr;
    while(temp!=nullptr)
    {
        x=temp->getNext();
        temp->setNext(prev);
        prev=temp;
        //x->next=prev;
        temp=x;
    }
    return prev;    
}




int main()
{
    /*Node x=Node(2,nullptr);
    Node* y=&x;
    cout<<y->getData()<<endl;
    Node* m=new Node(5,nullptr);
    cout<<m->getData()<<endl;*/

    vector<int>arr={12,9,34,6,7,8,3};
    /*Node* y=new Node(arr[0],nullptr);
    cout<<y->getData()<<endl;
    Node *z=new Node(arr[2]);
    cout<<z->getData()<<endl;*/

    Node* head=convert2LL(arr);
    cout<<head->getData()<<endl;
    traverseArray(head);
    cout<<sizeOfLL(head);
    cout<<endl;
    cout<<checkIfPresent(nullptr,3);
    cout<<endl;
    head=removehead(head);
    traverseArray(head);
    head=removetail(head);
    traverseArray(head);
    head=removeAnyPos(head,3);
    traverseArray(head);
    head=removeAnyPos(head,4);
    traverseArray(head);
    head=insertAtHead(head,170);
    traverseArray(head);
    head=insertAtTail(head,194);
    traverseArray(head);
    head=insertAnyPos(head,267,1);
    traverseArray(head);
    //head=insertAnyPos(nullptr,122,1);
    //traverseArray(head);
    //head=insertAtTail(nullptr,61);
    //traverseArray(head);
    head=insertAnyPos(head,19,7);
    traverseArray(head);
    head=insertAnyPos(head,110,4);
    traverseArray(head);
    head=insertBeforeVal(head,56,110);
    traverseArray(head);
    head=reversell(head);
    traverseArray(head);
 
}