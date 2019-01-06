defmodule KV.BucketTest do
  use ExUnit.Case, async: true

  setup do
    {:ok, bucket} = URL.Bucket.start_link([])
    %{bucket: bucket}
  end

  test "stores urls by key", %{bucket: bucket} do
    assert URL.Bucket.get(bucket, "10101") == nil

    URL.Bucket.put(bucket, "10101", "https://test.com")
    assert URL.Bucket.get(bucket, "10101") == "https://test.com"
  end
end
