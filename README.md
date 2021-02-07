"# University" 
Excersises, projects from University:)

RegexTraining
\p{L} matches a single code point in the category "letter".
\p{N} matches any kind of numeric character in any script "numeric".
\\  \\ - closed groups

. means "any character".
* means "any number of this".
.* therefore means an arbitrary string of arbitrary length.
^ indicates the beginning of the string.
 $ indicates the end of the string.
\s matches whitespace (spaces, tabs and new lines). \S is negated \s.
 
?i - ignore for example big small letters
\\b - one letter find -> The metacharacter \b is an anchor like the caret and the dollar sign.
\\ 1 refer to first group

\\d dowolne cyfry
d{1,2} 1 to 2 or \\p{N} // d{4} - 4 digits in number
In replacement using $, refer to group from regex. However in regex we using \\2 i.e.
[-/.] - every anchor in []
