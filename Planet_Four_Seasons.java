// Strugacarro is a planet whose year is divided into four seasons: winter, spring, summer and autumn in that order. A year has N days and every season lasts for exactly N/4 days. The year starts on the first day of winter and ends on the last day of autumn.

// Given the history of temperatures from the previous year, find the season with the highest amplitude of temperatures. The amplitude is the difference between the highest and lowest temperatures over the given period. Assume that all seasons within one year have different temperature amplitudes.

// Write a function:

// function solution(T);

// that, given an array T of N integers denoting the temperatures on all days of the year, returns a string with the name of the season with the highest temperature amplitude (one of the following: "WINTER", "SPRING", "SUMMER", "AUTUMN").

// For example, given T = [−3, −14, −5, 7, 8, 42, 8, 3]: // the function should return "SUMMER", since the highest amplitude (34) occurs in summer.

// Given T = [2, −3, 3, 1, 10, 8, 2, 5, 13, −5, 3, −18]: // the correct answer is "AUTUMN" (amplitude equals 21).

// Assume that:

// The number of elements in the array is divisible by 4; // each element of array T is an integer within the range [−1,000..1,000]; // N is an integer within the range [8..200]; // Amplitudes of all seasons are distinct. // In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

    public String maxAmp(int[] T) {
        String[] seasons = new String[]{"WINTER","SPRING","SUMMER","AUTUMN"};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int delta = -1;
        int ans = -1;
        for(int i = 0; i < T.length; i++) {
            if(i % 4 == 0) {
                //reset
                max = min = T[i];
            }
            else {
                if(T[i] > max) max = T[i];
                if(T[i] < min) min = T[i];
                if(max - min > delta) {
                    delta = max - min;
                    ans = i / 4;
                }
            }
        }
        return seasons[ans];
    }
