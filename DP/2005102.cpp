#include<bits/stdc++.h>
using namespace std;
void knapsack(vector<pair<int,int>>&vec,int items,int capacity)
{
    int weight[items+1];
    int val[items+1];
    int i,j;
    for(int i=0; i<=items; i++)
    {
        weight[i]=vec[i].first;
        val[i]=vec[i].second;
    }
    int solution[items+1][capacity+1];
    for(int j=0; j<=capacity; j++)
        solution[0][j]=0;

    for(int i=0; i<=items; i++)
        solution[i][0]=0;
    for(i=1; i<=items; i++)
    {
        for(j=1; j<=capacity; j++)
        {

            if(weight[i]<=j)
            {
                if((val[i]+solution[i-1][j-weight[i]])>solution[i-1][j])
                    solution[i][j]=val[i]+solution[i-1][j-weight[i]];
                else solution[i][j]=solution[i-1][j];

            }
            else solution[i][j]=solution[i-1][j];
        }
    }
    int result=solution[items][capacity];
    cout<<result<<endl;
    int col=capacity;
    vector<int>weigh;
    for(int i=items; i>0; i--)
    {
        if(result>=0)
        {
            if(result==solution[i-1][col])
                continue;
            else
            {
                weigh.push_back(weight[i]);
                result=result-val[i];
                col=col-weight[i];
            }
        }
    }
    for(int i=weigh.size()-1;i>=0;i--)
        cout<<weigh[i]<<" ";
}

int main()
{
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    int items,capacity;
    cin>>items;
    vector<pair<int,int>>v;
    v.push_back(make_pair(0,0));
    for(int i=0; i<items; i++)
    {
        int weight,value;
        cin>>weight>>value;
        v.push_back(make_pair(weight,value));
    }
    cin>>capacity;
    knapsack(v,items,capacity);
    fclose(stdin);
    fclose(stdout);
}

