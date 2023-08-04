import asyncio
import subprocess


async def run_client_test(i, j):
    cmd = f"java -cp out ClientTest"

    # Read the corresponding input for ClientTest from the file
    input_file = f"test/in/input_{j}.txt"
    with open(input_file, 'r') as f:
        client_input = f.read().strip()

    # Run ClientTest with input redirection and capture the output
    completed_process = await asyncio.subprocess.create_subprocess_shell(
        cmd, stdin=asyncio.subprocess.PIPE, stdout=asyncio.subprocess.PIPE
    )
    client_output, _ = await completed_process.communicate(input=client_input.encode())

    # Read the corresponding reference output from the file
    reference_file = f"test/output/reference_output_{j}.txt"
    with open(reference_file, 'r') as f:
        reference_output = f.read().strip()

    client_output_str = client_output.decode().strip()
    client_output_str = client_output_str.replace('\r\n', '\n')
    if client_output_str == reference_output:
        print(f"Client {i}, Test {j}: Output matches the reference.")
        return True
    else:
        print(f"Client {i}, Test {j}: Output does not match the reference.")
        print("Actual Output:\n", client_output_str)
        print("Reference Output:\n", reference_output)


async def main(num_clients, num_test):
    tasks = []
    for i in range(1, num_clients + 1):
        for j in range(1, num_test + 1):
            task = asyncio.create_task(run_client_test(i, j))
            tasks.append(task)

    # Wait for all tasks to complete
    results = await asyncio.gather(*tasks)
    passed_tests = sum(1 for result in results if result)
    print(f"\nNumber of tests passed: {passed_tests}/{num_clients * num_test}")


if __name__ == "__main__":
    num_clients = 10  # Replace with your desired value
    num_test = 5  # Replace with your desired value

    # NOTE: Actual number of client will be num_clients * num_test
    asyncio.run(main(num_clients, num_test))
