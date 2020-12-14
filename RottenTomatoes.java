class RottenTomatoes{
    public static void main(String[] args){
        int[][] ratings = { {4,6,2,5},
                            {7,9,4,8},
                            {6,9,3,7} };
        
        System.out.println("Movie zero's average rating: " + movieAvgRating(ratings, 0));                    
        System.out.println("Movie one's average rating: " + movieAvgRating(ratings, 1));    
        System.out.println("Reviewer zero's average rating: " + reviewerAvgRating(ratings, 0));    
        System.out.println("Reviewer one's average rating: " + reviewerAvgRating(ratings, 1));
        System.out.println("Average rating for all movies in 2018: " + avgRating2018(ratings));    
        System.out.println("Hardest reviewer is #" + hardestReviewer2018(ratings));
        System.out.println("Worst movie is #" + worstMovie2018(ratings));                         
    }     
    public static int movieAvgRating(int[][] ratings, int movie){
        int answer = 0;
        for (int r = 0; r < ratings.length; r++){
            answer = answer + ratings[r][movie];
        }
        answer = answer/ratings.length;
        
        return answer;
    }
    public static int reviewerAvgRating(int[][] ratings, int reviewer){
        int answer = 0;
        for (int c = 0; c < ratings[reviewer].length; c++){
            answer += ratings[reviewer][c];
        }
        answer = answer/ratings[0].length;
    
        return answer;
    }
    public  static int avgRating2018(int[][] ratings){
        int answer = 0;
        for (int r = 0; r < ratings.length; r++){
            for (int c = 0; c < ratings[0].length; c++){
                answer += ratings[r][c];
            }
        }
        answer = answer/(ratings.length * ratings[0].length);
    
        return answer;
    }
    public static int hardestReviewer2018(int[][] ratings){
        int Rater = 0;
        int Grade = 0;
        
        for (int i = 0; i < ratings[0].length; i++){// first rater first row
            Grade += ratings[0][i];
        }       
        for (int r = 1; r < ratings.length; r++){
            int TestGrade = 0;
            for (int c = 0; c < ratings[0].length; c++){
                TestGrade += ratings[r][c];
            }      
            if (TestGrade < Grade){
                Rater = r;
                Grade = TestGrade; 
            }
            //System.out.println("TestGrade: " + TestGrade);
            //System.out.println("Grade: " + Grade);
            //System.out.println("Rater: " + Rater);       
            //System.out.println("Grade: " + Grade);
            //System.out.println("");
            //break;
        }
        return Rater;
    }
    public static int worstMovie2018(int[][] ratings){
        int Movie = 0;
        int Grade = 0;
        
        for (int i = 0; i < ratings.length; i++){// first movie first column
            Grade += ratings[i][0];
        }
        //System.out.println(Grade);
        for (int c = 1; c < ratings[0].length; c++){
            int TestGrade = 0;
            for (int r = 0; r < ratings.length; r++){
                TestGrade += ratings[r][c];
            }
            if (TestGrade < Grade){
                Movie = c; 
                Grade = TestGrade;
            }
        }
    
        return Movie;
    }
}
