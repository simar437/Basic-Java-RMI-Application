#!/bin/bash

# Function to run the Java ClientTest with input redirection and compare output with reference output
run_client_test() {
    i=$1
    j=$2
    cmd="java -cp out ClientTest"

    # Read the corresponding input for ClientTest from the file
    input_file="test/in/input_${j}.txt"
    client_input=$(cat "$input_file")

    # Run ClientTest with input redirection and capture the output
    client_output=$(echo "$client_input" | $cmd)

    # Read the corresponding reference output from the file
    reference_file="test/output/reference_output_${j}.txt"
    reference_output=$(cat "$reference_file")

    # Compare the output
    if [ "$client_output" = "$reference_output" ]; then
        echo "Client $i, Test $j: Output matches the reference."
        return 0
    else
        echo "Client $i, Test $j: Output does not match the reference."
        echo "Actual Output:"
        echo "$client_output"
        echo "Reference Output:"
        echo "$reference_output"
        return 1
    fi
}

# Main function
main() {
    num_clients=10  # Replace with your desired value
    num_tests=5     # Replace with your desired value

    passed_tests=0

    for ((i=1; i<=num_clients; i++)); do
        for ((j=1; j<=num_tests; j++)); do
            if run_client_test "$i" "$j"; then
                ((passed_tests++))
            fi
        done
    done

    echo -e "\nNumber of tests passed: $passed_tests/$((num_clients * num_tests))"
}

main
