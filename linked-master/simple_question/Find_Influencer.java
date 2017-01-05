package simple_question;



/*
/ Given a matrix of following between N LinkedIn users (with ids from 0 to N-1): 
	followingMatrix[i][j] == true iff user i is following user j 
	thus followingMatrix[i][j] doesn't imply followingMatrix[j][i]. 
	Let's also agree that followingMatrix[i][i] == false
	Influencer is a user who is: - followed by everyone else and -
	 not following anyone himself 
	 This method should find an Influencer by a given matrix of following, 
	 or return -1 if there is no Influencer in this group. /
	  int getInfluencer(boolean[][] followingMatrix)*/
	
	
public class Find_Influencer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int getInfluencer(boolean[][] followingMatrix) {
	    if (followingMatrix == null || followingMatrix.length == 0) {
	        return 0;
	    }
	    assert followingMatrix.length == followingMatrix[0].length;
	    int len = followingMatrix.length;
	    int influencerId = 0;
	    for (int i = 1; i < len; ++i) {
	        if (followingMatrix[influencerId][i] || !followingMatrix[i][influencerId]) {
	            influencerId = i;
	        }
	    }
	    // verify it is indeed an influencer
	    for (int j = 0; j < len; ++j) {
	        if (influencerId == j) {
	            continue;
	        }
	        if (followingMatrix[influencerId][j] || !followingMatrix[j][influencerId]) {
	            return -1;
	        }
	    }
	    return influencerId;
	}

}