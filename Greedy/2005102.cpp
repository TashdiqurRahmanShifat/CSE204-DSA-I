#include<bits/stdc++.h>
using namespace std;
bool comparator(pair<int,int>&a,pair<int,int>&b)
{
    if (a.second == b.second) return a.first < b.first;
    return a.second<b.second;
}
void display(vector<pair<int,int>>&v)
{
    sort(v.begin(),v.end(),comparator);
    int j=0,count=0;
    //cout<<v[j].first<<" "<<v[j].second<<endl;
    vector<pair<int,int>>vec;
    vec.push_back(make_pair(v[j].first,v[j].second));
    count++;
    for(int i=1;i<v.size();i++)
    {
        if(v[i].first>=v[j].second)
        {
            vec.push_back(make_pair(v[i].first,v[i].second));
            count++;
            //cout<<v[i].first<<" "<<v[i].second<<endl;
            j=i;
        }
    }

    cout<<vec.size()<<endl;
    for(int i=0;i<vec.size();i++)
    {
        cout<<vec[i].first<<" "<<vec[i].second<<endl;
    }
}
int main()
{
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    int n;
    cin>>n;
    vector<pair<int,int>>v;
    for(int i=0;i<n;i++)
    {
        int start,finish;
        cin>>start>>finish;
        v.push_back(make_pair(start,finish));
    }
    display(v);
    fclose(stdin);
    fclose(stdout);
}
