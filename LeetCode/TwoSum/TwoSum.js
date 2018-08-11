
// O(n^2) time, O(1) space
// could use less space if array was guaranteed to be sorted
const TwoSum = (arr, target) => {
    for(let i = 0; i < arr.length; i++){
        for(let j = i + 1; j < arr.length; j++){
            if(arr[i] + arr[j] == target){
                return [arr[i], arr[j]];
            }
        }
    }
    throw new Error('No matching pair!');
};

console.log(`Items that add to the sum: ${TwoSum([2, 7, 11, 15], 9)}`);
