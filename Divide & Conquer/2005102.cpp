#include<bits/stdc++.h>
using namespace std;
int merge(int arr[],int start,int mid,int end,vector<pair<int,int>>&vec)
{
    int initialcount=0;
    int arraysize1=mid-start+1;
    int arraysize2=end-mid;
    int array1[arraysize1];
    int array2[arraysize2];
 //   vector<pair<int,int>>v;
    for(int i=0;i<arraysize1;i++)
    {
        array1[i]=arr[start+i];
    }
    for(int i=0;i<arraysize2;i++)
    {
        array2[i]=arr[mid+1+i];
    }
    int m=0,n=0,k=start;
    while(m<arraysize1&&n<arraysize2)
    {
        if(array1[m]<=array2[n])
        {
            arr[k]=array1[m];
            m++;
            k++;
        }
        else
        {
            arr[k]=array2[n];

            initialcount+=arraysize1-m;

            for(int j=m;j<arraysize1;j++)
            {
            //cout<<"("<<array1[m+j]<<","<<array2[o]<<")";}
                //for(int l=n;l<l+1;l++)
                {
                    //cout<<"("<<array1[j]<<","<<array2[n]<<")";
                    vec.push_back(make_pair(array1[j],array2[n]));

                }
            }

             n++;
            k++;
        }

    }

    while(m<arraysize1)
    {
        arr[k]=array1[m];
        m++;
        k++;
    }
    while(n<arraysize2)
    {
        arr[k]=array2[n];
        n++;k++;
    }

//    for(int length=0;length<v.size();length++)
//    {
//        cout<<"("<<v[length].first<<","<<v[length].second<<")";
//    }
    return initialcount;
}
int mergesort(int arr[],int start,int end,vector<pair<int,int>>&a)
{
    int count=0;

    if(start<end)
    {
        int mid=(start+end)/2;
        count=count+mergesort(arr,start,mid,a);
        count=count+mergesort(arr,mid+1,end,a);

        count=count+merge(arr,start,mid,end,a);

    }


    return count;
}

int main()
{
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++)
    {
        int x;cin>>x;
        arr[i]=x;
    }
    vector<pair<int,int>>v;
    cout<<"Count of Inversions:";
    cout<<mergesort(arr,0,n-1,v)<<endl;
    cout<<"Inverted Pairs:"<<endl;
    for(int i=0;i<v.size();i++)
    {
        cout<<"("<<v[i].first<<","<<v[i].second<<")"<<endl;
    }

}
