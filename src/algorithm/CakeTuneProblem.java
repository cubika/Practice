package algorithm;

import java.util.Arrays;

/*
 * �ӱ���ת����
 */
public class CakeTuneProblem {
    
    int[] m_cakeArray; // �ӱ���Ϣ����
    int m_nCakeCnt;    // �ӱ�����
    int m_nMaxSwap;    // ��ཻ������,���Ϊ2*(m_nCakeCnt-1)
    int[] m_swapArray; // �����������
    int[] m_reverseCakeArray; // ��ǰ��ת�ӱ���Ϣ����
    int[] m_reverseCakeArraySwap; // ��ǰ��ת�ӱ�������Ϣ����
    int m_nSearch; //��ǰ����������Ϣ
    
    public CakeTuneProblem(){
        m_nCakeCnt = 0;
        m_nMaxSwap = 0;
    }
    
    void run(int[] pCakeArray){
        init(pCakeArray);
        m_nSearch = 0;
        search(0);
    }

    void output(){
        for(int i = 0; i < m_nMaxSwap; i++)
            System.out.print(m_swapArray[i]+",");
        
        System.out.println(" Search Times:"+m_nSearch);
        System.out.println("Total Swap Times:"+m_nMaxSwap);
    }
    
    void init(int[] pCakeArray){
        assert( pCakeArray != null);
        assert( pCakeArray.length > 0);
        
        m_nCakeCnt = pCakeArray.length;
        
        m_cakeArray = new int[m_nCakeCnt];
        
        for(int i = 0; i < m_nCakeCnt; i++)
            m_cakeArray[i] = pCakeArray[i];
        
        m_nMaxSwap = upperBound(m_nCakeCnt);
        
        m_swapArray = new int[m_nMaxSwap];
        
        m_reverseCakeArray = new int[m_nCakeCnt];
        for(int i = 0; i < m_nCakeCnt; i++)
            m_reverseCakeArray[i] = m_cakeArray[i];
        
        m_reverseCakeArraySwap = new int[m_nMaxSwap];
    }
    
    
    int lowerBound(int[] pCakeArray)
    {        
        int t, ret = 0;
    
        for(int i = 1; i < pCakeArray.length; i++){
            t = pCakeArray[i] - pCakeArray[i-1];
            if( (t==1) || (t == -1)){
            }
            else{
                ret ++;
            }        
        }
        return ret;        
    }
    
    
    int upperBound(int nCakeCnt){
        //return (nCakeCnt-1)*2;
        return (nCakeCnt)*2;
    }
    
    
    void search(int step){
        int i, nEstimate;
        m_nSearch++;
        
        //��֦����
        nEstimate = lowerBound(m_reverseCakeArray);
        if( step + nEstimate > m_nMaxSwap || step >= m_nMaxSwap)
            return;
        
        //��ǰ������ź���ģ�˵����һ���������
        if( isSorted( m_reverseCakeArray)){
        	//��Ҫ�Ĳ�����С������Ǳ�ԭ�����ŵķ���
            if( step < m_nMaxSwap){
            	//������С�����Ͷ�Ӧ�ķ�ת���
                m_nMaxSwap = step;
                for(i = 0; i < m_nMaxSwap; i++)
                    m_swapArray[i] = m_reverseCakeArraySwap[i];
            }
            return;
        }
        //�൱�������������������ö�����е����
        for(i = 1; i < m_nCakeCnt; i++){
        	//����һ�η�ת
            revert(0,i);
            //����η�ת����һ������
            m_reverseCakeArraySwap[step] = i;
            //�ݹ�����
            search(step+1);
            //������֮����лָ�������ʹ����һ����ԭ��״̬��ʼ
            revert(0,i);
        }
        
    }
    
    boolean isSorted(int[] pCakeArray)
    {
        for(int i = 1; i < pCakeArray.length; i++)        
            if( pCakeArray[i-1] > pCakeArray[i])
                return false;
        return true;    
    }
    
    void revert(int nBegin, int nEnd)
    {
        assert( nEnd > nBegin);
        int t = 0;
        for( int i=nBegin, j=nEnd; i<j; i++,j--)
        {
            t = m_reverseCakeArray[i];
            m_reverseCakeArray[i] = m_reverseCakeArray[j];
            m_reverseCakeArray[j] = t;
        }
    }
    
    
    public static void main(String[] args) {
        CakeTuneProblem problem = new CakeTuneProblem();
        //int[] cakeArray = {3,2,1,6,5,4,9,8,7,0}; 
        int[] cakeArray = {4,3,5,2,6,1};
        problem.run(cakeArray);
        problem.output();
    }

}
