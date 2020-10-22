/**********************************************************************************************************************/
/*  Written in 2018 by David Blackman and Sebastiano Vigna (vigna@acm.org)

To the extent possible under law, the author has dedicated all copyright
and related and neighboring rights to this software to the public domain
worldwide. This software is distributed without any warranty.

See <http://creativecommons.org/publicdomain/zero/1.0/>. */

/* Edited by D.Pizzolotto to add some application-specific features */

#include <stdint.h>

/* This is xoshiro256** 1.0, one of our all-purpose, rock-solid
   generators. It has excellent (sub-ns) speed, a state (256 bits) that is
   large enough for any parallel application, and it passes all tests we
   are aware of.

   For generating just floating-point numbers, xoshiro256+ is even faster.

   The state must be seeded so that it is not everywhere zero. If you have
   a 64-bit seed, we suggest to seed a splitmix64 generator and use its
   output to fill s. */

static inline uint64_t rotl(const uint64_t x, int k) {
	return (x << k) | (x >> (64 - k));
}

static uint64_t prng_state[4];
static uint8_t long_jump;
static uint8_t short_jump;

uint64_t next_rng_internal(void) {
	const uint64_t result = rotl(prng_state[1] * 5, 7) * 9;

	const uint64_t t = prng_state[1] << 17;

	prng_state[2] ^= prng_state[0];
	prng_state[3] ^= prng_state[1];
	prng_state[1] ^= prng_state[2];
	prng_state[0] ^= prng_state[3];
	prng_state[2] ^= t;
	prng_state[3] = rotl(prng_state[3], 45);

	return result;
}

void jump_rng(void) {
	static const uint64_t JUMP[] = { 0x180ec6d33cfd0aba, 0xd5a61266f0c9392c, 0xa9582618e03fc9aa, 0x39abdc4529b1661c };
	uint64_t s0 = 0;
	uint64_t s1 = 0;
	uint64_t s2 = 0;
	uint64_t s3 = 0;
	for(int i = 0; i < sizeof JUMP / sizeof *JUMP; i++)
		for(int b = 0; b < 64; b++) {
			if (JUMP[i] & UINT64_C(1) << b) {
				s0 ^= prng_state[0];
				s1 ^= prng_state[1];
				s2 ^= prng_state[2];
				s3 ^= prng_state[3];
			}
			next_rng_internal();
		}
	prng_state[0] = s0;
	prng_state[1] = s1;
	prng_state[2] = s2;
	prng_state[3] = s3;
}

void long_jump_rng(void) {
	static const uint64_t LONG_JUMP[] = { 0x76e15d3efefdcbbf, 0xc5004e441c522fb3, 0x77710069854ee241, 0x39109bb02acbe635 };
	uint64_t s0 = 0;
	uint64_t s1 = 0;
	uint64_t s2 = 0;
	uint64_t s3 = 0;
	for(int i = 0; i < sizeof LONG_JUMP / sizeof *LONG_JUMP; i++)
		for(int b = 0; b < 64; b++) {
			if (LONG_JUMP[i] & UINT64_C(1) << b) {
				s0 ^= prng_state[0];
				s1 ^= prng_state[1];
				s2 ^= prng_state[2];
				s3 ^= prng_state[3];
			}
			next_rng_internal();
		}
	prng_state[0] = s0;
	prng_state[1] = s1;
	prng_state[2] = s2;
	prng_state[3] = s3;
}

uint64_t next_rng()
{
uint64_t result = next_rng_internal();
if(result%short_jump==0)
        jump_rng();
    else if(result%long_jump==0)
        long_jump_rng();
    return result;
}
/**********************************************************************************************************************/
