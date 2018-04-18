/*
 * Copyright 2018 Pronghorn Technology LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tech.pronghorn.coroutines.awaitable.queue

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import tech.pronghorn.test.PronghornTest
import tech.pronghorn.test.lightRepeatCount
import tech.pronghorn.util.roundToNextPowerOfTwo

class QueueUtilTests : PronghornTest() {
    @RepeatedTest(lightRepeatCount)
    fun validValuesTest() {
        val value = Math.pow(2.0, (2.0 + random.nextInt(10))).toInt()
        assertEquals(value, validateQueueCapacity(value))
    }

    @RepeatedTest(lightRepeatCount)
    fun validateAtLeastFourTest() {
        ignoreLogging {
            val value = random.nextInt(3) - random.nextInt(4)
            assertEquals(4, validateQueueCapacity(value))
        }
    }

    @RepeatedTest(lightRepeatCount)
    fun roundToPowerOfTwoTest() {
        ignoreLogging {
            val value = 4 + random.nextInt(64)
            val oddValue = value + ((value % 2) + 1)
            val nextPower = roundToNextPowerOfTwo(oddValue)
            assertEquals(nextPower, validateQueueCapacity(oddValue))
        }
    }
}