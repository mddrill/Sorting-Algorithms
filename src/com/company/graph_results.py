import matplotlib.pyplot as plt
from matplotlib.backends.backend_pdf import PdfPages
import sys

def graph_results(insertion_sort_times, merge_sort_times, quicksort_times):
    element_numbers = [i for i in range(5000, 100001, 5000)]
    
    fig1 = plt.figure()
    ax1 = fig1.add_subplot(111)
    ax1.plot(element_numbers, insertion_sort_times, color='r', label='Insertion Sort')
    ax1.plot(element_numbers, merge_sort_times, color='b', label='Merge Sort')
    ax1.plot(element_numbers, quicksort_times, color='g', label='Quicksort')
    plt.legend(loc='upper left')
    plt.xlabel('Number Of Elements')
    plt.ylabel('Time to sort (ms)')
#    plt.show()
    with PdfPages('algorithm-comparisons.pdf') as pdf:
        pdf.savefig(fig1)
    fig2 = plt.figure()
    ax2 = fig2.add_subplot(111)
    ax2.plot(element_numbers, insertion_sort_times, color='r', label='Insertion Sort')
    ax2.plot(element_numbers, merge_sort_times, color='b', label='Merge Sort')
    ax2.plot(element_numbers, quicksort_times, color='g', label='Quicksort')
    plt.legend(loc='upper left')
    plt.xlabel('Number Of Elements')
    plt.ylabel('Time to sort (ms)')
    ax2.set_yscale('log')
    with PdfPages('algorithm-comparisons-logarithmic.pdf') as pdf:
        pdf.savefig(fig2)
    plt.show()


def main():
    print 'Now graphing the results...'
    if len(sys.argv) != 4:
        raise RuntimeError('Invalid Input: Need three args for three algorithms')
    insertion_sort_times = sys.argv[1].split(',')
    merge_sort_times = sys.argv[2].split(',')
    quicksort_times = sys.argv[3].split(',')
    graph_results(insertion_sort_times, merge_sort_times, quicksort_times)

if __name__=='__main__':
    main()

