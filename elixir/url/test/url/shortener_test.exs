defmodule URL.ShortenerTest do
  use ExUnit.Case, async: true

  setup do
    url = "http://teste.com"
    %{url: url}
    hash = 10101
    %{hash: hash}
  end

  test "it shortens urls into a hash", %{url: url} do
    {:ok, hash} = URL.Shortener.shorten(url)
  end

  test "it returns a url if given a hash", %{hash: hash} do
    {:ok, url} = URL.Shortener.expand(hash)
  end
end
