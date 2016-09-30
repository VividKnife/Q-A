#£¡/bin/python
import sys
import os

def mathDonuts(donutPairs,candidatePairs):
	f = open(os.environ['OUTPUT_PATH'],'w')
	_donutPairs_rows = 0
	_donutPairs_cols = 0
	_donutPairs_rows = int(raw_input())
	_donutPairs_cols = int(raw_input())

	_donutPairs = []
	for _donutPairs_i in xrange(_donutPairs_rows):
		_donutPairs_temp = map(str,raw_input().strip().split(' '))
		_donutPairs.append(_donutPairs_temp)
	_candidatePairs_rows