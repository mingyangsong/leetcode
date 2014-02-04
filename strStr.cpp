class Solution {
public:
    char *strStr(char *haystack, char *needle) {
        if (!*needle) 
            return haystack;
        int len=strlen(haystack)-strlen(needle);
        while (len>=0) {
            char *temp1 = needle;
            char *temp2 = haystack;
            while (*temp1 && *temp2 && *temp1 == *temp2) {
                ++temp1;
                ++temp2;
            }
            if (!*temp1) 
                return haystack;
            ++haystack;
            len--;
        }
        return NULL;
    }
};
