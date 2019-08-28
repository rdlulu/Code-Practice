// Strugacarro is a planet whose year is divided into four seasons: winter, spring, summer and autumn in that order. A year has N days and every season lasts for exactly N/4 days. The year starts on the first day of winter and ends on the last day of autumn.

// Given the history of temperatures from the previous year, find the season with the highest amplitude of temperatures. The amplitude is the difference between the highest and lowest temperatures over the given period. Assume that all seasons within one year have different temperature amplitudes.

// Write a function:

// function solution(T);

// that, given an array T of N integers denoting the temperatures on all days of the year, returns a string with the name of the season with the highest temperature amplitude (one of the following: "WINTER", "SPRING", "SUMMER", "AUTUMN").

// For example, given T = [−3, −14, −5, 7, 8, 42, 8, 3]: // the function should return "SUMMER", since the highest amplitude (34) occurs in summer.

// Given T = [2, −3, 3, 1, 10, 8, 2, 5, 13, −5, 3, −18]: // the correct answer is "AUTUMN" (amplitude equals 21).

// Assume that:

// The number of elements in the array is divisible by 4; // each element of array T is an integer within the range [−1,000..1,000]; // N is an integer within the range [8..200]; // Amplitudes of all seasons are distinct. // In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

seasons = ('WINTER', 'SPRING', 'SUMMER', 'AUTUMN')
print(seasons[max(enumerate([max(T[i * len(T) / 4 : (i + 1) * len(T) / 4]) - min(T[i * len(T) / 4 : (i + 1) * len(T) / 4]) for i in range(4) for j in range(i * len(T) / 4, (i + 1) * len(T) / 4)]), key=lambda x : x[1])[0]])
