/**
 * Created by shufan on 16/9/29.
 */
public class GasStation {
        public static void main(String[] args)
        {
            int[] gas  = new int[]{4,5,6,6,6,6,8,6,6,5,6,6,6};
            int[] cost = new int[]{5,5,6,6,6,6,6,6,6,6,6,6,6};

            System.out.println(canCompleteCircuit(gas,cost));
        }

        public static int canCompleteCircuit(int[] gas, int[] cost) {
            int start = 0,total=0,tank=0;
            //if car fails at 'start', record the next station
            for(int i=0;i<gas.length;i++) if((tank=tank+gas[i]-cost[i])<0) {start=i+1;total+=tank;tank=0;}
            return (total+tank<0)? -1:start;
//            int maxgas=0;
//            int maxstation=0;
//            if(gas[0]<cost[0] && gas.length==1) return -1;
//            for(int i = 0; i < gas.length; i++)
//            {
//                if((gas[i]-cost[i])>=maxgas){
//                    maxgas = gas[i] - cost[i];
//                    maxstation = i;
//                    //if(i+1==gas.length) gas[0] = maxgas;
//                    //else   gas[i+1] = maxgas;
//                }
//
//            }
//            System.out.println(maxstation+" "+maxgas);
//            for(int k = maxstation;;)
//            {
//                if(gas[k]<cost[k]) return -1;
//                if(k+1==gas.length)
//                {   gas[0] = gas[k]-cost[k]+gas[0];
//                    k = 0;
//                    System.out.println("0");
//
//                }
//                else{
//                    gas[k+1] = gas[k]-cost[k]+gas[k+1];
//                    k++;
//                    System.out.println("gas "+gas[k]);
//                }
//                if(k==maxstation) break;
//
//
//            }
//            return maxstation;

        }
}
