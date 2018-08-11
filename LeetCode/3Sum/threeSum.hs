threeSum :: (RealFloat a) => ([a],a) -> [(a, a, a)]
threeSum (list,sum) = [(a, b, c) | c <- list, b <- list, a <- list, a + b + c == sum]
