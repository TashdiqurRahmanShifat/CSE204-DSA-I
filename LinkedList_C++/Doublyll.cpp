#include<bits/stdc++.h>
using namespace std;

class Node{
private:
    int data;
    Node* next;
    Node* prev;
public:
    Node(int data)
    {
        this->data=data;
        this->next=nullptr;
        this->prev=nullptr;
    }
    Node(int data,Node* next,Node* prev)
    {
        this->data=data;
        this->next=next;
        this->prev=prev;
    }
    int getData()
    {
        return this->data;
    }
    void setPrev(Node* prev)
    {
        this->prev=prev;
    }
    void setNext(Node* next)
    {
        this->next=next;
    }
    Node* getPrev()
    {
        return this->prev;
    }
    Node* getNext()
    {
        return this->next;
    }
};

Node* convert2dl(vector<int>&arr)
{
    Node *head=new Node(arr[0]);
    Node *temp=head;
    for(int i=1;i<arr.size();i++)
    {
        Node* x=new Node(arr[i],nullptr,temp);
        temp->setNext(x);
        temp=temp->getNext();
    }
    return head;
}

void print(Node* head)
{
    Node* temp=head;
    while(temp!=nullptr)
    {
        cout<<temp->getData()<<" ";
        temp=temp->getNext();
    }
    cout<<endl;
}

void reverseOrderPrint(Node* head)
{
    Node* temp=head;
    while(temp->getNext()!=nullptr)
    {
        temp=temp->getNext();
    }
    while(temp!=nullptr)
    {
        cout<<temp->getData()<<" ";
        temp=temp->getPrev();
    }
    cout<<endl;
}

Node* deleteHead(Node* head)
{
    if(head==nullptr)return nullptr;
    if(head->getNext()==nullptr)
    {
        delete head;
        return nullptr;
    }
    Node* temp=head;
    head=head->getNext();
    head->setPrev(nullptr);
    temp->setNext(nullptr);
    delete(temp);
    return head;

}

Node* deleteTail(Node* head)
{
    if(head==nullptr)return nullptr;
    if(head->getNext()==nullptr)
    {
        delete head;
        return nullptr;
    }
    Node* temp=head;
    while(temp->getNext()!=nullptr)
    {
        temp=temp->getNext();
    }
    Node* tempPrev=temp->getPrev();
    tempPrev->setNext(nullptr);
    temp->setPrev(nullptr);
    delete temp;
    return head;
}

Node* deleteAnyPos(Node* head,int k)
{
    if(head==nullptr)return nullptr;
    if(k==1)return deleteHead(head);
    int count=0;
    Node* temp=head;
    while(temp->getNext()!=nullptr)
    {
        count++;
        if(count==k)
        {
            temp->getPrev()->setNext(temp->getNext());
            temp->getNext()->setPrev(temp->getPrev());
            
            temp->setNext(nullptr);
            temp->setPrev(nullptr);
            delete temp;
            break;
        }
        temp=temp->getNext();
    }
    if(count+1==k)
    {
        temp->getPrev()->setNext(nullptr);
        temp->setPrev(nullptr);
        delete temp;
    }
    return head;
}

Node* deleteNode(Node* node)
{
    if(node==nullptr)return nullptr;
    Node* prevNode=node->getPrev();
    Node* nextNode=node->getNext();
    //this is for head deletion
    
    if(prevNode==nullptr)
    {
        nextNode->setPrev(nullptr);
        node->setNext(nullptr);
        delete node;
        return nextNode;
    }
    if(nextNode==nullptr)
    {
        prevNode->setNext(nullptr);
        node->setPrev(nullptr);
        delete node;
        while(prevNode->getPrev()!=nullptr)
        {
            prevNode=prevNode->getPrev();
        }
        return prevNode;
    }
    prevNode->setNext(nextNode);
    nextNode->setPrev(prevNode);
    node->setNext(nullptr);
    node->setPrev(nullptr);
    delete node;
    while(prevNode->getPrev()!=nullptr)
    {
        prevNode=prevNode->getPrev();
    }
    return prevNode;    
    
}

Node* insertBeforeHead(Node* head,int val)
{
    Node* x=new Node(val,head,nullptr);
    head->setPrev(x);
    head=x;
    return head;

}

Node* insertBeforeTail(Node* head,int val)
{
    if(head->getNext()==nullptr)return insertBeforeHead(head,val);
    Node* temp=head;
    while(temp->getNext()!=nullptr)
    {
        temp=temp->getNext();
    } 
    Node* prevNode=temp->getPrev();
    Node* x=new Node(val,temp,prevNode);
    prevNode->setNext(x);
    temp->setPrev(x);
    return head;
}

Node* insertAtAnyPos(Node* head,int val,int k)
{
    if(head==nullptr)return nullptr;
    if(k==1)return insertBeforeHead(head,val);
    Node* temp=head;
    Node* prev=nullptr;
    int count=0;
    while(temp!=nullptr)
    {
        count++;
        //cout<<count<<" "<<temp->getData()<<endl;
        if(count==k)
        {
            Node* x=new Node(val,temp,temp->getPrev());
            temp->getPrev()->setNext(x);
            temp->setPrev(x);
            break;
        }
        prev=temp;
        temp=temp->getNext();
        
    }
    if(k==count+1)
    {
        Node* x=new Node(val,nullptr,prev);
        prev->setNext(x);
    }
    return head;
}

void insertBeforeNode(Node* node,int val)
{
    Node* temp=new Node(val,node,node->getPrev());
    node->getPrev()->setNext(temp);
    node->setPrev(temp);
}

Node* reverseDLL(Node * head)
{
    Node* prevNode=nullptr;
    Node* x=nullptr;
    Node* temp=head;
    while(temp!=nullptr)
    {
        //prevNode=temp->getPrev();
        temp->setPrev(temp->getNext());
        x=temp->getNext();
        temp->setNext(prevNode);
        prevNode=temp;
        temp=x;
    }
    return prevNode;
}

Node* removeallduplicate(Node* head,int k)
{
    if(head==nullptr)return nullptr;
    Node* dummy=new Node(-1);
    Node* prev=dummy;
    Node* temp=head;
    while(temp!=nullptr)
    {
        if(temp->getData()==k)
        {
            Node* x=temp;
            temp=temp->getNext();
            x->setNext(nullptr);
            x->setPrev(nullptr);
            delete x;
            prev->setNext(temp);
            continue;
        }
        else{
            prev->setNext(temp);
            temp->setPrev(prev);
            prev=prev->getNext();
        }
        temp=temp->getNext();
    }
    return dummy->getNext();
}

int main()
{
    vector<int>arr={2,2,3,4,5,6,9,3,2,8,2,2,2,12,94,1,2};
    Node* head=convert2dl(arr);
    /*    print(head);
    //reverseOrderPrint(head);
    head=deleteHead(head);
    print(head);
    head=deleteTail(head);
    print(head);
    head=deleteAnyPos(head,8);
    print(head);
    head=deleteNode(head->getNext()->getNext()->getNext()->getNext()->getNext()->getNext());
    //head=deleteNode(head->getNext()->getNext());
    //head=deleteHead(head);
    print(head);
    head=insertBeforeHead(head,170);
    print(head);
    head=insertBeforeTail(head,194);
    print(head);
    head=insertAtAnyPos(head,40,7);
    print(head);
    //reverseOrderPrint(head);
    insertBeforeNode(head->getNext()->getNext()->getNext()->getNext()->getNext()->getNext()->getNext()->getNext(),110);
    print(head);
    head=reverseDLL(head);
    print(head);*/
    head=removeallduplicate(head,2);
    print(head);
}